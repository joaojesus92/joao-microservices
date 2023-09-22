package br.com.joaojesus.bookservice.controller;

import br.com.joaojesus.bookservice.client.response.CambiumResponse;
import br.com.joaojesus.bookservice.config.SimpleBookCambiumMapper;
import br.com.joaojesus.bookservice.model.Book;
import br.com.joaojesus.bookservice.proxy.CambiumProxy;
import br.com.joaojesus.bookservice.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book endpoint")
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

  @Operation(summary = "Find a specific book by your ID")
  @GetMapping("/{id}/{currency}")
  public Book findBook(@PathVariable(name = "id") Long id, @PathVariable(name = "currency") String currency) {
    var book = repository.findById(id);

    final Book optBook = book.orElseThrow(() -> {
      throw new RuntimeException("Book not found");
    });

    final CambiumResponse response = proxy.getCambium(optBook.getPrice(), "USD", currency);
    final CambiumResponse cambiumResponse = mapper.responseToResponse(response);

    var port = environment.getProperty("local.server.port");

    optBook.setEnvironment("Book port: " + port + " Cambio port: " + cambiumResponse.getEnvironment());
    optBook.setPrice(cambiumResponse.getConvertedValue());

    return optBook;
  }
}
