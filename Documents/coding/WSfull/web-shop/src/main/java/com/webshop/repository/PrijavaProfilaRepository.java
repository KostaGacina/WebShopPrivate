package com.webshop.repository;

import com.webshop.model.Kategorija;
import com.webshop.model.PrijavaProfila;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrijavaProfilaRepository extends JpaRepository<PrijavaProfila, Long> {
}
