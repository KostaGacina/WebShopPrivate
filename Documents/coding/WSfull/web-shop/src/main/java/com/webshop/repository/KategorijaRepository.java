package com.webshop.repository;

import com.webshop.model.Kategorija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategorijaRepository extends JpaRepository<Kategorija, Long> {
    Kategorija findByNaziv(String naziv);
}
