package br.dev.diego.springredis.repositories;

import br.dev.diego.springredis.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
