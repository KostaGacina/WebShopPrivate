package com.webshop.dto;


import com.webshop.model.Kategorija;
import com.webshop.model.Proizvod;

import java.math.BigDecimal;

public class ProizvodDto {

    private Long id;

    private String naziv;

    private String opis;

    private Kategorija kategorija;

    private BigDecimal cena;

    private String slika;

    private Proizvod.tipprodaje tipProdaje;

    public ProizvodDto(String naziv,long ProdavacId, String opis, Kategorija kategorija, BigDecimal cena, String slika, Proizvod.tipprodaje tipProdaje) {
        this.naziv = naziv;
        this.opis = opis;
        this.kategorija = kategorija;
        this.cena = cena;
        this.slika = slika;
        this.tipProdaje = tipProdaje;
        this.ProdavacId = ProdavacId;
    }

    public ProizvodDto(String naziv, String opis, Kategorija kategorija, BigDecimal cena, String slika, Proizvod.tipprodaje tipProdaje) { }


    public ProizvodDto(Long id, String naziv, String opis, Kategorija kategorija, BigDecimal cena, String slika, Proizvod.tipprodaje tipProdaje) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.kategorija = kategorija;
        this.cena = cena;
        this.slika = slika;
        this.tipProdaje = tipProdaje;
    }




    public long getProdavacId() {
        return ProdavacId;
    }

    public void setProdavacId(long prodavacId) {
        ProdavacId = prodavacId;
    }

    private long ProdavacId;

    public ProizvodDto() {
    }




    public Long getId() { return id; }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public String getSlika() {
        return slika;
    }

    public Proizvod.tipprodaje getTipProdaje() {
        return tipProdaje;
    }

    public void setId(Long id) { this.id = id; }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public void setTipProdaje(Proizvod.tipprodaje tipProdaje) {
        this.tipProdaje = tipProdaje;
    }

}
