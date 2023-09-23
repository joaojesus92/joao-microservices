package br.com.joaojesus.model;

import br.com.joaojesus.service.Cambio;
import java.math.BigDecimal;

public abstract class Exchange {
  Cambio cambio;

  public Exchange() {
  }

  public BigDecimal doConvertAmount(BigDecimal conversionFactor, BigDecimal amount) {
    return cambio.convertAmount(conversionFactor, amount);
  }
}
