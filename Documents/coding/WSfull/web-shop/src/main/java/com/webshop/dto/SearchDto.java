package com.webshop.dto;

import com.webshop.model.Kategorija;
import com.webshop.model.Proizvod;

import java.math.BigDecimal;

public class SearchDto {

    private String imeopis;

    private BigDecimal cenaod;

    private BigDecimal cenado;

    private Kategorija kategorija;

    private Proizvod.tipprodaje tipP;

    private String flagovi;

    public SearchDto() {
    }

    public SearchDto(String imeopis, BigDecimal cenaod, BigDecimal cenado, Kategorija kategorija, Proizvod.tipprodaje tipP, String flagovi) {
        this.imeopis = imeopis;
        this.cenaod = cenaod;
        this.cenado = cenado;
        this.kategorija = kategorija;
        this.tipP = tipP;
        this.flagovi = flagovi;
    }

    public String getImeopis() {
        return imeopis;
    }

    public BigDecimal getCenaod() {
        return cenaod;
    }

    public BigDecimal getCenado() {
        return cenado;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public Proizvod.tipprodaje getTipP() {
        return tipP;
    }

    public String getFlagovi() {
        return flagovi;
    }

    public void setImeopis(String imeopis) {
        this.imeopis = imeopis;
    }

    public void setCenaod(BigDecimal cenaod) {
        this.cenaod = cenaod;
    }

    public void setCenado(BigDecimal cenado) {
        this.cenado = cenado;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public void setTipP(Proizvod.tipprodaje tipP) {
        this.tipP = tipP;
    }
    //[0] search [1] cneaOd [2] denaDo [3] kategorija [4] tipProdaje
    public void setFlagovi(String flagovi) {
        this.flagovi = flagovi;
    }
}
