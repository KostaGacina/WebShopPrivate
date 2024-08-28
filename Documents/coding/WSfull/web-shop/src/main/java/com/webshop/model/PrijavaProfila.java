package com.webshop.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class PrijavaProfila implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String razlogPrijave;

    @Column
    private LocalDate datumPodnosenjaPrijave;

    @JoinColumn(name = "korisnik_podneo_prijavu_id") @ManyToOne
    private Korisnik korisnikKojiJePodneoPrijavu;

    @JoinColumn(name = "korisnik_prijavljen_id") @ManyToOne
    private Korisnik korisnikNaKogaSeOdnosiPrijavu;

    public enum statPrijave {podneta, prihvacena, odbijena};

    @Column @Enumerated
    private statPrijave statusPrijave;

    public long getId() {
        return id;
    }

    public String getRazlogPrijave() {
        return razlogPrijave;
    }

    public LocalDate getDatumPodnosenjaPrijave() {
        return datumPodnosenjaPrijave;
    }

    public Korisnik getKorisnikKojiJePodneoPrijavu() {
        return korisnikKojiJePodneoPrijavu;
    }

    public Korisnik getKorisnikNaKogaSeOdnosiPrijavu() {
        return korisnikNaKogaSeOdnosiPrijavu;
    }

    public statPrijave getStatusPrijave() {
        return statusPrijave;
    }

    public void setRazlogPrijave(String razlogPrijave) {
        this.razlogPrijave = razlogPrijave;
    }

    public void setDatumPodnosenjaPrijave(LocalDate datumPodnosenjaPrijave) {
        this.datumPodnosenjaPrijave = datumPodnosenjaPrijave;
    }

    public void setKorisnikKojiJePodneoPrijavu(Korisnik korisnikKojiJePodneoPrijavu) {
        this.korisnikKojiJePodneoPrijavu = korisnikKojiJePodneoPrijavu;
    }

    public void setKorisnikNaKogaSeOdnosiPrijavu(Korisnik korisnikNaKogaSeOdnosiPrijavu) {
        this.korisnikNaKogaSeOdnosiPrijavu = korisnikNaKogaSeOdnosiPrijavu;
    }

    public void setStatusPrijave(statPrijave statusPrijave) {
        this.statusPrijave = statusPrijave;
    }

    public PrijavaProfila(long id, String razlogPrijave, LocalDate datumPodnosenjaPrijave, Korisnik korisnikKojiJePodneoPrijavu, Korisnik korisnikNaKogaSeOdnosiPrijavu, statPrijave statusPrijave) {
        this.id = id;
        this.razlogPrijave = razlogPrijave;
        this.datumPodnosenjaPrijave = datumPodnosenjaPrijave;
        this.korisnikKojiJePodneoPrijavu = korisnikKojiJePodneoPrijavu;
        this.korisnikNaKogaSeOdnosiPrijavu = korisnikNaKogaSeOdnosiPrijavu;
        this.statusPrijave = statusPrijave;
    }

    public PrijavaProfila() {
    }
}
