package com.webshop.repository;

import com.webshop.dto.ProizvodDto;
import com.webshop.model.Kategorija;
import com.webshop.model.Proizvod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProizvodRepository extends JpaRepository<Proizvod, Long> {

    @Query(value = "select new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) from Proizvod p")
    Page<ProizvodDto> findAllPageable(Pageable pageable);

    @Query(value = "select new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) from Proizvod p WHERE p.tipProdaje = :tipProdaje")
    Page<ProizvodDto> findByTipProdaje(Proizvod.tipprodaje tipProdaje, Pageable pageable);

    @Query(value = "select new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) from Proizvod p WHERE p.kategorija = :kategorija")
    Page<ProizvodDto> findByKategorija(Kategorija kategorija, Pageable pageable);

    @Query(value = "select new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) from Proizvod p WHERE p.kategorija = :kategorija AND p.tipProdaje = :tipProdaje")
    Page<ProizvodDto> findByTipProdajeAndKategorija(Proizvod.tipprodaje tipProdaje, Kategorija kategorija, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.cena <= :cenado" )
    Page<ProizvodDto> findByCenaLeCenaDo(BigDecimal cenado, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.cena <= :cenado AND p.tipProdaje = :tipProdaje" )
    Page<ProizvodDto> findByCenaLeCenaDoAndTipProdaje(BigDecimal cenado, Proizvod.tipprodaje tipProdaje, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.cena <= :cenado AND p.kategorija = :kategorija" )
    Page<ProizvodDto> findByCenaLeCenaDoAndKategorija(BigDecimal cenado, Kategorija kategorija, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.cena <= :cenado AND p.kategorija = :kategorija AND p.tipProdaje = :tipProdaje" )
    Page<ProizvodDto> findByCenaLeCenaDoAndKategorijaAndTipProdaje(BigDecimal cenado, Kategorija kategorija, Proizvod.tipprodaje tipProdaje, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.cena >= :cenaod" )
    Page<ProizvodDto> findByCenaGeCenaOd(BigDecimal cenaod, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.cena >= :cenaod AND p.tipProdaje = :tipProdaje" )
    Page<ProizvodDto> findByCenaGeCenaOdAndTipPRodaje(BigDecimal cenaod, Proizvod.tipprodaje tipProdaje, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.cena >= :cenaod AND p.kategorija = :kategorija" )
    Page<ProizvodDto> findByCenaGeCenaOdAndKategorija(BigDecimal cenaod, Kategorija kategorija, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.cena >= :cenaod AND p.kategorija = :kategorija AND p.tipProdaje = :tipProdaje" )
    Page<ProizvodDto> findByCenaGeCenaOdAndKategorijaAndTipProdaje(BigDecimal cenaod, Kategorija kategorija, Proizvod.tipprodaje tipProdaje, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.cena >= :cenaod AND p.cena <= :cenado" )
    Page<ProizvodDto> findByCenaBetween(BigDecimal cenaod, BigDecimal cenado, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.cena >= :cenaod AND p.cena <= :cenado AND p.tipProdaje = :tipProdaje" )
    Page<ProizvodDto> findByCenaBetweenAndTipProdaje(BigDecimal cenaod, BigDecimal cenado, Proizvod.tipprodaje tipProdaje,Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.cena >= :cenaod AND p.cena <= :cenado AND p.kategorija = :kategorija" )
    Page<ProizvodDto> findByCenaBetweenAndKategorija(BigDecimal cenaod, BigDecimal cenado, Kategorija kategorija, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.cena >= :cenaod AND p.cena <= :cenado AND p.kategorija = :kategorija AND p.tipProdaje = :tipProdaje" )
    Page<ProizvodDto> findByCenaBetweenAndKategorijaAndTipProdaje(BigDecimal cenaod, BigDecimal cenado, Kategorija kategorija, Proizvod.tipprodaje tipProdaje, Pageable pageable);

    //---------
    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%")
    Page<ProizvodDto> findByNazivOrOpis(String nazivIliopis, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.tipProdaje = :tipProdaje" )
    Page<ProizvodDto> findByNazivOrOpisAndTipProdaje(String nazivIliopis, Proizvod.tipprodaje tipProdaje, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.kategorija = :kategorija" )
    Page<ProizvodDto> findByNazivOrOpisAndKategorija(String nazivIliopis, Kategorija kategorija, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.kategorija = :kategorija AND p.tipProdaje = :tipProdaje" )
    Page<ProizvodDto> findByNazivOrOpisAndKategorijaAndTipProdaje(String nazivIliopis, Kategorija kategorija, Proizvod.tipprodaje tipProdaje, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.cena <= :cenado" )
    Page<ProizvodDto> findByNazivOrOpisAndLtCenaDo(String nazivIliopis, BigDecimal cenado, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.cena <= :cenado AND p.tipProdaje = :tipProdaje" )
    Page<ProizvodDto> findByNazivOrOpisAndLtCenaDoAndTipProdaje(String nazivIliopis, BigDecimal cenado, Proizvod.tipprodaje tipProdaje, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE p.cena <= :cenado AND p.kategorija = :kategorija AND (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%)" )
    Page<ProizvodDto> findByNazivOrOpisAndLtCenaDoAndKategorija(String nazivIliopis, BigDecimal cenado, Kategorija kategorija, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.cena <= :cenado AND p.kategorija = :kategorija AND p.tipProdaje = :tipProdaje" )
    Page<ProizvodDto> findByNazivOrOpisAndLtCenaDoAndKategorijaAndTipProdaje(String nazivIliopis, BigDecimal cenado, Kategorija kategorija, Proizvod.tipprodaje tipProdaje, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.cena >= :cenaod" )
    Page<ProizvodDto> findByNazivOrOpisAndGtCenaOd(String nazivIliopis, BigDecimal cenaod, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.cena >= :cenaod AND p.tipProdaje = :tipProdaje" )
    Page<ProizvodDto> findByNazivOrOpisAndGtCenaOdAndTipProdaje(String nazivIliopis, BigDecimal cenaod, Proizvod.tipprodaje tipProdaje,Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.cena >= :cenaod AND p.kategorija = :kategorija" )
    Page<ProizvodDto> findByNazivOrOpisAndGtCenaOdAndKategorija(String nazivIliopis, BigDecimal cenaod, Kategorija kategorija,Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.cena >= :cenaod AND p.kategorija = :kategorija AND p.tipProdaje = :tipProdaje" )
    Page<ProizvodDto> findByNazivOrOpisAndGtCenaOdAndKategorijaAndTipProdaje(String nazivIliopis, BigDecimal cenaod, Kategorija kategorija, Proizvod.tipprodaje tipProdaje, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.cena BETWEEN :cenaod AND :cenado" )
    Page<ProizvodDto> findByNazivOrOpisAndCenaBetween(String nazivIliopis, BigDecimal cenaod, BigDecimal cenado, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.tipProdaje = :tipProdaje AND p.cena BETWEEN :cenaod AND :cenado" )
    Page<ProizvodDto> findByNazivOrOpisAndCenaBetweenAndTipProdaje(String nazivIliopis, BigDecimal cenaod, BigDecimal cenado, Proizvod.tipprodaje tipProdaje, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.kategorija = :kategorija AND p.cena BETWEEN :cenaod AND :cenado" )
    Page<ProizvodDto> findByNazivOrOpisAndCenaBetweenAndKategorija(String nazivIliopis, BigDecimal cenaod, BigDecimal cenado, Kategorija kategorija, Pageable pageable);

    @Query(value = "SELECT new com.webshop.dto.ProizvodDto(p.id, p.naziv, p.opis, p.kategorija, p.cena, p.slika, p.tipProdaje) FROM Proizvod p WHERE (p.naziv LIKE %:nazivIliopis% OR p.opis LIKE %:nazivIliopis%) AND p.tipProdaje = :tipProdaje AND p.kategorija = :kategorija AND p.tipProdaje = :tipProdaje AND p.cena BETWEEN :cenaod AND :cenado" )
    Page<ProizvodDto> findByNazivOrOpisAndCenaBetweenAndKategorijaAndTipProdaje(String nazivIliopis, BigDecimal cenaod, BigDecimal cenado, Kategorija kategorija, Proizvod.tipprodaje tipProdaje, Pageable pageable);

}