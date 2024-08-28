package com.webshop.service;

import com.webshop.model.Korisnik;
import com.webshop.model.PrijavaProfila;
import com.webshop.repository.KorisnikRepository;
import com.webshop.repository.PrijavaProfilaRepository;
import com.webshop.repository.ProizvodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrijavaProfilaService {

    @Autowired
    private PrijavaProfilaRepository prijavaProfilaRepository;
    @Autowired
    private ProizvodRepository proizvodRepository;

    public void save(PrijavaProfila prijavaProfila) {
        prijavaProfilaRepository.save(prijavaProfila);
    }

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private EmailService emailService;

    public List<PrijavaProfila> getAllPrijave() {
        return prijavaProfilaRepository.findAll();
    }

    public void odbijPrijavu(Long prijavaId, String razlogOdbijanja) {
        PrijavaProfila prijava = prijavaProfilaRepository.findById(prijavaId)
                .orElseThrow(() -> new IllegalArgumentException("Prijava with ID " + prijavaId + " not found."));
        prijava.setStatusPrijave(PrijavaProfila.statPrijave.valueOf("odbijena"));

        Korisnik korisnik = prijava.getKorisnikNaKogaSeOdnosiPrijavu();
        Korisnik korisnik2 = prijava.getKorisnikKojiJePodneoPrijavu();
        String subject  = "Odgovor na podnesenu prijavu";
        String body = "Smatramo da nemamo osnova za blokiranje  " + korisnik.getKorisnickoIme();
        emailService.sendNewMail(korisnik2.getMejlAdresa(),subject,body);

        prijavaProfilaRepository.save(prijava);
    }

    public void prihvatiPrijavu(Long prijavaId) {
        PrijavaProfila prijava = prijavaProfilaRepository.findById(prijavaId)
                .orElseThrow(() -> new IllegalArgumentException("Prijava with ID " + prijavaId + " not found."));
        prijava.setStatusPrijave(PrijavaProfila.statPrijave.valueOf("prihvacena"));

        Korisnik korisnik = prijava.getKorisnikNaKogaSeOdnosiPrijavu();
        Korisnik korisnik2 = prijava.getKorisnikKojiJePodneoPrijavu();
        korisnik.setBlokiran(true);
        korisnik.getPrizvodi().forEach(proizvod -> {
            proizvodRepository.delete(proizvod);
        });

        String subject2 = "Odgovor na podnesenu prijavu";
        String body2 = "korisnik " + korisnik.getKorisnickoIme() + "je blokiran";

        String subject = "Obavestenje o blokiranju";
        String body = "Nakon razmatranja prijave podnesene prema vama, odlucili smo da suspendujemo vas profil";

        korisnikRepository.save(korisnik);
        emailService.sendNewMail(korisnik.getMejlAdresa(),subject,body);
        emailService.sendNewMail(korisnik2.getMejlAdresa(),subject2, body2);
        prijavaProfilaRepository.save(prijava);
    }

}
