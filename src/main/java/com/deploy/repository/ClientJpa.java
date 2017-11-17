package com.deploy.repository;

import com.deploy.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpa extends JpaRepository<Client, Integer> {
}
