package br.com.joaojesus.controller;

import br.com.joaojesus.model.Cambium;
import br.com.joaojesus.service.impl.ManageExchangesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@Tag(name = "Cambium service API")
@RestController
@RequestMapping("/cambio-service")
public class CambiumController {

  private Logger log = LoggerFactory.getLogger(CambiumController.class);

  @Autowired
  private ManageExchangesServiceImpl manageExchangesService;

  @Operation(description = "Get cambium from currency")
  @GetMapping("/{amount}/{from}/{to}")
  public Cambium getCambium(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from, @PathVariable("to") String to) {
    log.info("CambiumController - getCambium is called with -> {}, {} and {} ", amount, from, to);
    return manageExchangesService.exchange(from, to, amount);
  }
}
