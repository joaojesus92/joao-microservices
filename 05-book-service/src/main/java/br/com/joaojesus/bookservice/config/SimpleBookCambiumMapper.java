package br.com.joaojesus.bookservice.config;

import br.com.joaojesus.bookservice.client.response.CambiumResponse;
import org.mapstruct.Mapper;

@Mapper
public interface SimpleBookCambiumMapper {
  CambiumResponse responseToResponse(CambiumResponse response);
}
