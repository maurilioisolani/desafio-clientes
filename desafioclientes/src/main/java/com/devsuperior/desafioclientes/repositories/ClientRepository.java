package com.devsuperior.desafioclientes.repositories;

import com.devsuperior.desafioclientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
