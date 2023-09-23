package br.com.joaojesus.repository;

import br.com.joaojesus.model.Cambium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambiumRepository extends JpaRepository<Cambium,Long> {

  Cambium findByFromAndTo(String from, String to);
}
