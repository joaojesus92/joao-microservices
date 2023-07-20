package br.com.joaojesus.model;

import br.com.joaojesus.service.impl.DollarToReal;

public class ExchangeBrl extends Exchange{

  public ExchangeBrl() {
    cambio = new DollarToReal();
  }

  public String toPresent() {
    return "I am exchange from Brazil";
  }
}
