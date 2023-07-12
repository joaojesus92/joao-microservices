package br.com.joaojesus.bookservice.controller;

import br.com.joaojesus.bookservice.client.response.CambiumResponse;
import br.com.joaojesus.bookservice.config.SimpleBookCambiumMapper;
import br.com.joaojesus.bookservice.model.Book;
import br.com.joaojesus.bookservice.proxy.CambiumProxy;
import br.com.joaojesus.bookservice.repository.BookRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;

@RestController
@RequestMapping("book-service")
public class BookController {

  @Autowired
  private Environment environment;

  @Autowired
  private BookRepository repository;

  private SimpleBookCambiumMapper mapper = Mappers.getMapper(SimpleBookCambiumMapper.class);

  @Autowired
  private CambiumProxy proxy;

  @GetMapping("/{id}/{currency}")
  public Book findBook(@PathVariable(name = "id") Long id,
                       @PathVariable(name = "currency") String currency)
  {
    var book = repository.findById(id);

    final Book optBook = book.orElseThrow(() -> {
      throw new RuntimeException("Book not found");
    });

    HashMap<String, String> params = new HashMap<>();
    params.put("amount", optBook.getPrice().toString());
    params.put("from", "USD");
    params.put("to", currency);

    var response = new RestTemplate()
      .getForEntity("http://localhost:8000/cambio-service/" +
                      "{amount}/{from}/{to}", CambiumResponse.class, params);

    final CambiumResponse cambiumResponse = mapper.responseToResponse(response.getBody());

    var port = environment.getProperty("local.server.port");

    optBook.setEnvironment(port);
    optBook.setPrice(cambiumResponse.getConvertedValue());

    return optBook;
  }
}
