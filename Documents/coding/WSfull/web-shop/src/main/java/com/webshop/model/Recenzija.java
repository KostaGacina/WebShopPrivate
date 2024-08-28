package com.webshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Recenzija implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double ocena;

    @Column
    private String komentar;

    @Column//(name = "datum_recenzije")
    private LocalDate datumRecenzije;

    @ManyToOne
    @JoinColumn//(name = "korisnik_id")  KORISNIK KOJI JE DAO RECENZIJU
    @JsonBackReference
    private Korisnik korisnik;

    public Recenzija() {

    }

    public double getOcena() {
        return ocena;
    }

    public Long getId() {
        return id;
    }

    public String getKomentar() {
        return komentar;
    }

    public LocalDate getDatumRecenzije() {
        return datumRecenzije;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public void setDatumRecenzije(LocalDate datumRecenzije) {
        this.datumRecenzije = datumRecenzije;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Recenzija(double ocena, String komentar, LocalDate datumRecenzije, Korisnik korisnik) {
        this.ocena = ocena;
        this.komentar = komentar;
        this.datumRecenzije = datumRecenzije;
        this.korisnik = korisnik;
    }
}
