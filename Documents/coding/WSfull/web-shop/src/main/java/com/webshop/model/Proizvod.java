package com.webshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Proizvod implements Serializable {

    public enum tipprodaje {aukcija, fiksnaCena}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String naziv;

    @Column
    private String opis;

    @Column
    private String slika;

    @ManyToOne @JoinColumn
    private Kategorija kategorija;

    @Column
    private BigDecimal cena;

    @Column @Enumerated
    private tipprodaje tipProdaje;

    @Column
    private Date datumObjavljivanja;

    @Column @OneToMany(fetch = FetchType.EAGER)
    private Set<Ponuda> ponude;

    @ManyToOne
    @JoinColumn(name = "prodavac_id")
    @JsonBackReference
    private Korisnik prodavac;

    @Column(name = "ostavljenja_recenzija_od_strane_kupca")
    private boolean ostavljenaRecenzijaOdStraneKupca;

    @Column(name = "ostavljenja_recenzija_od_strane_prodavca")
    private boolean ostavljenaRecenzijaOdStraneProdavca;

    @Column
    private boolean prodat;

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public void setDatumObjavljivanja(Date datumObjavljivanja) {
        this.datumObjavljivanja = datumObjavljivanja;
    }

    public void setTipProdaje(tipprodaje tipProdaje) {
        this.tipProdaje = tipProdaje;
    }

    public void setPonude(Set<Ponuda> ponude) {
        this.ponude = ponude;
    }

    public void setProdavac(Korisnik prodavac) {
        this.prodavac = prodavac;
    }

    public void setOstavljenaRecenzijaOdStraneKupca(boolean ostavljenaRecenzijaOdStraneKupca) {
        this.ostavljenaRecenzijaOdStraneKupca = ostavljenaRecenzijaOdStraneKupca;
    }

    public void setOstavljenaRecenzijaOdStraneProdavca(boolean ostavljenaRecenzijaOdStraneProdavca) {
        this.ostavljenaRecenzijaOdStraneProdavca = ostavljenaRecenzijaOdStraneProdavca;
    }

    public void setProdat(boolean prodat) {
        this.prodat = prodat;
    }

    public long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public String getSlika() {
        return slika;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public Date getDatumObjavljivanja() {
        return datumObjavljivanja;
    }

    public tipprodaje getTipProdaje() {
        return tipProdaje;
    }

    public Set<Ponuda> getPonude() {
        return ponude;
    }

    public Korisnik getProdavac() {
        return prodavac;
    }

    public boolean isOstavljenaRecenzijaOdStraneKupca() {
        return ostavljenaRecenzijaOdStraneKupca;
    }

    public boolean isOstavljenaRecenzijaOdStraneProdavca() {
        return ostavljenaRecenzijaOdStraneProdavca;
    }

    public boolean isProdat() {
        return prodat;
    }
}
