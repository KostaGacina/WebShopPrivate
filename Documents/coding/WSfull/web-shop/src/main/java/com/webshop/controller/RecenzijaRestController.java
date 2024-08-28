package com.webshop.controller;

import com.webshop.dto.RecenzijaDto;
import com.webshop.model.Korisnik;
import com.webshop.model.Recenzija;
import com.webshop.service.RecenzijaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/recenzije")
public class RecenzijaRestController {

    @Autowired
    private RecenzijaService recenzijaService;

    @GetMapping
    public ResponseEntity<List<Recenzija>> vratiSveRecenzije(HttpSession session) {
        if (session.getAttribute("korisnik") == null) {
            return new ResponseEntity("Zabranjen pristup", HttpStatus.UNAUTHORIZED);
        }
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if(korisnik.getUloga() == Korisnik.TipKorisnika.Administrator) {
            List<Recenzija> reviews = recenzijaService.vratiSveRecenzije();
            return ResponseEntity.ok(reviews);
        }

        return new ResponseEntity("Zabranjen pristup", HttpStatus.FORBIDDEN);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> izmeniRecenziju(@PathVariable Long reviewId, @RequestBody RecenzijaDto recenzijaDto, HttpSession session) {
        if (session.getAttribute("korisnik") == null) {
            return new ResponseEntity("Zabranjen pristup", HttpStatus.UNAUTHORIZED);
        }
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if(korisnik.getUloga() == Korisnik.TipKorisnika.Administrator) {
            recenzijaService.izmeniRecenziju(reviewId, recenzijaDto);
            return ResponseEntity.ok("Recenzija uspešno izmenjena.");
        }
        return new ResponseEntity("Zabranjen pristup", HttpStatus.FORBIDDEN);

    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> izbrisiRecenziju(@PathVariable Long reviewId, HttpSession session) {
        if (session.getAttribute("korisnik") == null) {
            return new ResponseEntity("Zabranjen pristup", HttpStatus.UNAUTHORIZED);
        }
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if(korisnik.getUloga() == Korisnik.TipKorisnika.Administrator) {
            recenzijaService.izbrisiRecenziju(reviewId);
            return ResponseEntity.ok("Recenzija uspesno izbrisana.");
        }
        return new ResponseEntity("Zabranjen pristup", HttpStatus.FORBIDDEN);

    }
}

