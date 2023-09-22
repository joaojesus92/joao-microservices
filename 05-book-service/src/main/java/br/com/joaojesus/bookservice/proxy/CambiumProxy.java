package br.com.joaojesus.bookservice.proxy;

import br.com.joaojesus.bookservice.client.response.CambiumResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "cambio-service", url = "${api.cambio-service.base-url}")
@FeignClient(name = "cambio-service")
public interface CambiumProxy {

  @GetMapping("/cambio-service/{amount}/{from}/{to}")
  CambiumResponse getCambium(@PathVariable("amount") Double amount, @PathVariable("from") String from, @PathVariable("to") String to);

}
