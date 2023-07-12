package br.com.joaojesus.bookservice.client.response;

import java.util.Objects;

public class CambiumResponse {

  private Long id;
  private String from;
  private String to;
  private Double conversionFactor;
  private Double convertedValue;
  private String environment;

  public CambiumResponse() {
  }

  public CambiumResponse(Long id, String from, String to, Double conversionFactor, Double convertedValue, String environment) {
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

  public Double getConversionFactor() {
    return conversionFactor;
  }

  public void setConversionFactor(Double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public Double getConvertedValue() {
    return convertedValue;
  }

  public void setConvertedValue(Double convertedValue) {
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
    if (!(o instanceof CambiumResponse that)) return false;
    return Objects.equals(getId(), that.getId()) && Objects.equals(getFrom(), that.getFrom()) && Objects.equals(getTo(), that.getTo()) && Objects.equals(getConversionFactor(), that.getConversionFactor()) && Objects.equals(getConvertedValue(), that.getConvertedValue()) && Objects.equals(getEnvironment(), that.getEnvironment());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getFrom(), getTo(), getConversionFactor(), getConvertedValue(), getEnvironment());
  }
}
