package com.webshop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public enum TipKorisnika {Prodavac, Kupac, Administrator}

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(unique = true/*, name = "korisnicko_ime"*/)
    private String korisnickoIme;

    @Column(unique = true/*, name = "mejl_adresa"*/)
    private String mejlAdresa;

    @Column(unique = true/*, name = "broj_telefona"*/)
    private String brojTelefona;

    @Column(nullable = false)
    private String lozinka;

    @Column//(name = "datum_rodjenja")
    private Date datumRodjenja;

    @Column//(name = "putanja_do_slike")
    private String putanjaDoSlike;

    @Column
    private String opis;

    @Column/*(name = "uloga")*/ @Enumerated
    private TipKorisnika uloga;

    @Column(nullable = false)
    private boolean blokiran;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Proizvod> prizvodi = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Recenzija> recenzije = new HashSet<>();

    @Column
    private double prosecnaOcena;

    public Set<Proizvod> getPrizvodi() {
        return prizvodi;
    }

    public Set<Recenzija> getRecenzije() {
        return recenzije;
    }

    public Long getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getMejlAdresa() {
        return mejlAdresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public String getLozinka() {
        return lozinka;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public String getPutanjaDoSlike() {
        return putanjaDoSlike;
    }

    public String getOpis() {
        return opis;
    }

    public boolean isBlokiran() {
        return blokiran;
    }



    public double getProsenaOcena() {
        return prosecnaOcena;
    }

    public TipKorisnika getUloga() {
        return uloga;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public void setMejlAdresa(String mejlAdresa) {
        this.mejlAdresa = mejlAdresa;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public void setPutanjaDoSlike(String putanjaDoSlike) {
        this.putanjaDoSlike = putanjaDoSlike;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setBlokiran(boolean blokiran) {
        this.blokiran = blokiran;
    }

    public void setProsenaOcena(double prosenaOcena) {
        this.prosecnaOcena = prosenaOcena;
    }

    public void setUloga(TipKorisnika uloga) {
        this.uloga = uloga;
    }

}
