package br.com.joaojesus.repository;

import br.com.joaojesus.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

  Cambio findByFromAndTo(String from, String to);
}
