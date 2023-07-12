package br.com.joaojesus.bookservice.dto;

public class CambiumDTO {

  private Long id;
  private String from;
  private String to;
  private Double conversionFactor;
  private Double convertedValue;
  private String environment;

  public CambiumDTO() {
  }

  public CambiumDTO(Long id, String from, String to, Double conversionFactor, Double convertedValue, String environment) {
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

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public Double getConversionFactor() {
    return conversionFactor;
  }

  public Double getConvertedValue() {
    return convertedValue;
  }

  public String getEnvironment() {
    return environment;
  }
}
