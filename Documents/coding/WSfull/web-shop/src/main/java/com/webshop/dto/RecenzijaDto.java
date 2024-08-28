package com.webshop.dto;

import com.webshop.model.Proizvod;

public class RecenzijaDto {
    private Long id;
    private double ocena;
    private String komentar;
    private ProizvodDto proizvodDto;

    public RecenzijaDto() {
    }

    public RecenzijaDto(Long id, double ocena, String komentar, ProizvodDto proizvodDto) {
        this.id = id;
        this.ocena = ocena;
        this.komentar = komentar;
        this.proizvodDto = proizvodDto;
    }

    public RecenzijaDto(double ocena, String komentar, ProizvodDto proizvodDto) {
        this.ocena = ocena;
        this.komentar = komentar;
        this.proizvodDto = proizvodDto;
    }

    public Long getId() {
        return id;
    }

    public double getOcena() {
        return ocena;
    }

    public String getKomentar() {
        return komentar;
    }

    public ProizvodDto getProizvodDto() {
        return proizvodDto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public void setProizvodDto(ProizvodDto proizvodDto) {
        this.proizvodDto = proizvodDto;
    }
}
