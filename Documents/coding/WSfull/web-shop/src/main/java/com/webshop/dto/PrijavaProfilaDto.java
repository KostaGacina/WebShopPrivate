package com.webshop.dto;

import com.webshop.model.Korisnik;
import com.webshop.model.PrijavaProfila;
import com.webshop.model.Proizvod;

import java.time.LocalDate;

public class PrijavaProfilaDto {

    Proizvod proizvod;

    PrijavaProfila prijava;

    public PrijavaProfilaDto() {
    }

    public PrijavaProfilaDto(Proizvod proizvod, PrijavaProfila prijava) {
        this.proizvod = proizvod;
        this.prijava = prijava;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public PrijavaProfila getPrijava() {
        return prijava;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public void setPrijava(PrijavaProfila prijava) {
        this.prijava = prijava;
    }
}
