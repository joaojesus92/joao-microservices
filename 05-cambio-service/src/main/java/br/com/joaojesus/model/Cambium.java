package br.com.joaojesus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "cambio")
public class Cambium implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "from_currency", nullable = false, length = 3)
  private String from;

  @Column(name = "to_currency", nullable = false, length = 3)
  private String to;

  @Column(nullable = false)
  private BigDecimal conversionFactor;

  @Transient
  private BigDecimal convertedValue;

  @Transient
  private String environment;

  public Cambium() {
  }

  public Cambium(Long id, String from, String to, BigDecimal conversionFactor, BigDecimal convertedValue, String environment) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionFactor = conversionFactor;
    this.convertedValue = convertedValue;
    this.environment = environment;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public BigDecimal getConversionFactor() {
    return conversionFactor;
  }

  public void setConversionFactor(BigDecimal conversionFactory) {
    this.conversionFactor = conversionFactory;
  }

  public BigDecimal getConvertedValue() {
    return convertedValue;
  }

  public void setConvertedValue(BigDecimal convertedValue) {
    this.convertedValue = convertedValue;
  }

  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Cambium)) return false;
    Cambium cambio = (Cambium) o;
    return Objects.equals(getId(), cambio.getId()) && Objects.equals(getFrom(), cambio.getFrom()) && Objects.equals(getTo(), cambio.getTo()) && Objects.equals(getConversionFactor(), cambio.getConversionFactor()) && Objects.equals(getConvertedValue(), cambio.getConvertedValue()) && Objects.equals(getEnvironment(), cambio.getEnvironment());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getFrom(), getTo(), getConversionFactor(), getConvertedValue(), getEnvironment());
  }
}
