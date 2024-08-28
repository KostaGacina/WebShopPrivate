package com.webshop.repository;

import com.webshop.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Korisnik findByKorisnickoIme(String koisnickoIme);

    Korisnik findByKorisnickoImeOrMejlAdresa(String koisnickoIme, String mejlAdresa);

}
