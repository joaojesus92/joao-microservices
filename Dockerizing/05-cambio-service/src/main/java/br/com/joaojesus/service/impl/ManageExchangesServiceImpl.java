package br.com.joaojesus.service.impl;

import br.com.joaojesus.model.Cambium;
import br.com.joaojesus.model.Exchange;
import br.com.joaojesus.model.ExchangeBrl;
import br.com.joaojesus.repository.CambiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Objects;

@Service
public class ManageExchangesServiceImpl {

  @Autowired
  private CambiumRepository repository;

  @Autowired
  private Environment environment;

  public Cambium exchange(String from, String to, BigDecimal amount) {
    var port = environment.getProperty("local.server.port");
    final Cambium cambium = getCambium(from, to);

    Exchange exchange = new ExchangeBrl();
    final BigDecimal amountConverted = exchange.doConvertAmount(cambium.getConversionFactor(), amount);

    cambium.setConvertedValue(amountConverted);
    cambium.setEnvironment(port);

    return cambium;
  }

  private Cambium getCambium(String fromCurrency, String toCurrency) throws RuntimeException {
    var cambiumEntity = repository.findByFromAndTo(fromCurrency, toCurrency);
    if (Objects.isNull(cambiumEntity)) throw new RuntimeException("Currency Unsupported");

    return cambiumEntity;
  }
}
