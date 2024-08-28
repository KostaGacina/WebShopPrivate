package com.webshop.controller;
import com.webshop.model.Korisnik;
import com.webshop.model.PrijavaProfila;
import com.webshop.service.PrijavaProfilaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prijave")
public class PrijavaProfilaRestController {

    @Autowired
    private PrijavaProfilaService prijavaService;

    @GetMapping
    public ResponseEntity<List<PrijavaProfila>> getAllPrijave(HttpSession session) {
        if (session.getAttribute("korisnik") == null) {
            return new ResponseEntity("Zabranjen pristup", HttpStatus.UNAUTHORIZED);
        }
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if(korisnik.getUloga() == Korisnik.TipKorisnika.Administrator) {
            List<PrijavaProfila> prijave = prijavaService.getAllPrijave();
            return ResponseEntity.ok(prijave);
        }

        return new ResponseEntity("Zabranjen pristup", HttpStatus.FORBIDDEN);

    }

    @PutMapping("/{prijavaId}/odbij")
    public ResponseEntity<String> odbijPrijavu(@PathVariable Long prijavaId, @RequestParam String razlogOdbijanja, HttpSession session) {
        if (session.getAttribute("korisnik") == null) {
            return new ResponseEntity("Zabranjen pristup", HttpStatus.UNAUTHORIZED);
        }
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if(korisnik.getUloga() == Korisnik.TipKorisnika.Administrator) {
            prijavaService.odbijPrijavu(prijavaId, razlogOdbijanja);
            return ResponseEntity.ok("Prijava odbijena.");
        }

        return new ResponseEntity("Zabranjen pristup", HttpStatus.FORBIDDEN);

    }

    @PutMapping("/{prijavaId}/prihvati")
    public ResponseEntity<String> prihvatiPrijavu(@PathVariable Long prijavaId, HttpSession session) {
        if (session.getAttribute("korisnik") == null) {
            return new ResponseEntity("Zabranjen pristup", HttpStatus.UNAUTHORIZED);
        }
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if(korisnik.getUloga() == Korisnik.TipKorisnika.Administrator) {
            prijavaService.prihvatiPrijavu(prijavaId);
            return ResponseEntity.ok("Prijava prihvaćena.");
        }

        return new ResponseEntity("Zabranjen pristup", HttpStatus.FORBIDDEN);

    }
}