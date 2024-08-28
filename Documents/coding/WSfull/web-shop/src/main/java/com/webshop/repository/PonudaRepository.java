package com.webshop.repository;

import com.webshop.model.Ponuda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PonudaRepository extends JpaRepository<Ponuda,Long> {
}
