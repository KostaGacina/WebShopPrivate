package com.webshop.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Ponuda implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal Cena;

    @JoinColumn(name = "kupac_id") @ManyToOne(fetch = FetchType.EAGER)
    private Korisnik kupacKojiJeDaoPonudu;

    public BigDecimal getCena() {
        return Cena;
    }

    public Long getId() {
        return id;
    }

    public Korisnik getKupacKojiJeDaoPonudu() {
        return kupacKojiJeDaoPonudu;
    }

    public void setCena(BigDecimal cena) {
        Cena = cena;
    }

    public void setKupacKojiJeDaoPonudu(Korisnik kupacKojiJeDaoPonudu) {
        this.kupacKojiJeDaoPonudu = kupacKojiJeDaoPonudu;
    }

    public Ponuda() {
    }

    public Ponuda( BigDecimal cena, Korisnik kupacKojiJeDaoPonudu) {
        Cena = cena;
        this.kupacKojiJeDaoPonudu = kupacKojiJeDaoPonudu;
    }
}
