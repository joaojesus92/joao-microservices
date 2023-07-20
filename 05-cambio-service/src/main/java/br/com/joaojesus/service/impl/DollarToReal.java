package br.com.joaojesus.service.impl;

import br.com.joaojesus.service.Cambio;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class DollarToReal implements Cambio {

  @Override
  public BigDecimal convertAmount(BigDecimal conversionFactor, BigDecimal amount) {
    return conversionFactor.multiply(amount).setScale(2, RoundingMode.CEILING);
  }
}
