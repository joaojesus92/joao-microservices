package br.com.joaojesus.controller;

import br.com.joaojesus.model.Cambio;
import br.com.joaojesus.repository.CambioRepository;
import br.com.joaojesus.service.impl.ManageExchangesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Objects;

@RestController
@RequestMapping("/cambio-service")
public class CambioController {

  @Autowired
  private ManageExchangesServiceImpl manageExchangesService;

  @GetMapping("/{amount}/{from}/{to}")
  public Cambio getCambio(@PathVariable("amount") BigDecimal amount,
                          @PathVariable("from") String from,
                          @PathVariable("to") String to)
  {
    var cambio = repository.findByFromAndTo(from, to);




    cambio.setEnvironment(port);

    return new Cambio(1L, cambio.getFrom(), cambio.getTo(), BigDecimal.ONE, BigDecimal.ONE, port);
  }
}
