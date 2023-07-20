package br.com.joaojesus.controller;

import br.com.joaojesus.model.Cambium;
import br.com.joaojesus.service.impl.ManageExchangesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
@RequestMapping("/cambio-service")
public class CambiumController {

  @Autowired
  private ManageExchangesServiceImpl manageExchangesService;

  @GetMapping("/{amount}/{from}/{to}")
  public Cambium getCambium(@PathVariable("amount") BigDecimal amount,
                            @PathVariable("from") String from,
                            @PathVariable("to") String to)
  {
    return manageExchangesService.exchange(from, to, amount);
  }
}
