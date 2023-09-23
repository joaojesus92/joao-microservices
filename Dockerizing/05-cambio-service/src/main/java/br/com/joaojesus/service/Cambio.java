package br.com.joaojesus.service;

import java.math.BigDecimal;

public interface Cambio {

  BigDecimal convertAmount(BigDecimal conversionFactor, BigDecimal amount);
}
