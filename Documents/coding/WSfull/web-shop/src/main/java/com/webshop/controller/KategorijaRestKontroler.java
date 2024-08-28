package com.webshop.controller;

import com.webshop.dto.ProizvodDto;
import com.webshop.dto.SearchDto;
import com.webshop.model.Kategorija;
import com.webshop.model.Korisnik;
import com.webshop.model.Proizvod;
import com.webshop.service.KategorijaService;
import com.webshop.service.ProizvodService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class KategorijaRestKontroler {

    @Autowired
    private KategorijaService kategorijaService;

    @Autowired
    private ProizvodService proizvodService;

    @GetMapping("/api/categories")
    public ResponseEntity<List<Kategorija>> getKategorije(HttpSession sesija) {
        Korisnik korisnik = (Korisnik) sesija.getAttribute("korisnik");
        if(korisnik == null) {
            List<Kategorija> kategorije = kategorijaService.findAll();
            return ResponseEntity.ok(kategorije);
        }
        if(korisnik.getUloga() != Korisnik.TipKorisnika.Administrator){
            List<Kategorija> kategorije = kategorijaService.findAll();
            return ResponseEntity.ok(kategorije);
        }
        return new ResponseEntity("Zabranjen pristup", HttpStatus.FORBIDDEN);
    }

    @GetMapping("/api/category/{id}/{str}")
    public ResponseEntity<Page<ProizvodDto>> getKategorija(@PathVariable("id") Long id, HttpSession sesija, @PathVariable int str) {
        Korisnik korisnik = (Korisnik) sesija.getAttribute("korisnik");
        if(korisnik == null) {
            Kategorija kategorija = kategorijaService.findById(id);
            if (kategorija == null) {
                return new ResponseEntity("Kategorija sa tim id-om nije nadjena!", HttpStatus.NOT_FOUND);
            }
            SearchDto sdto = new SearchDto("", BigDecimal.ZERO, BigDecimal.ZERO, kategorija, Proizvod.tipprodaje.aukcija, "00010");
            Page<ProizvodDto> strProizvodaPoKategoriji = proizvodService.proizvodiSearchOrFilter(sdto, str);
            return ResponseEntity.ok(strProizvodaPoKategoriji);
        }
        if(korisnik.getUloga() != Korisnik.TipKorisnika.Administrator){
            Kategorija kategorija = kategorijaService.findById(id);
            if (kategorija == null) {
                return new ResponseEntity("Kategorija sa tim id-om nije nadjena!", HttpStatus.NOT_FOUND);
            }
            SearchDto sdto = new SearchDto("", BigDecimal.ZERO, BigDecimal.ZERO, kategorija, Proizvod.tipprodaje.aukcija, "00010");
            Page<ProizvodDto> strProizvodaPoKategoriji = proizvodService.proizvodiSearchOrFilter(sdto, str);
            return ResponseEntity.ok(strProizvodaPoKategoriji);
        }
        return new ResponseEntity("Zabranjen pristup", HttpStatus.FORBIDDEN);
    }

}
