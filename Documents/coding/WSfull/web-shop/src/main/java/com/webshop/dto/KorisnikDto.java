package com.webshop.dto;

import com.webshop.model.Proizvod;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class KorisnikDto {
                private String trenutnaLozinka;
                private String novaLozinka;
                private String korisnickoIme;
                private String email;
                private Date datumRodjenja;
                private String profilnaSlika;
                private String opis;
                private String brojTelefona;
                private String ime;
                private String prezime;
                private Set<Proizvod> Prizvodi  = new HashSet<>();



        public KorisnikDto() {
        }

        public KorisnikDto(String trenutnaLozinka, String novaLozinka, String korisnickoIme, String email, Date datumRodjenja,
                           String profilnaSlika, String opis, String brojTelefona, String prezime, String ime) {
                this.trenutnaLozinka = trenutnaLozinka;
                this.novaLozinka = novaLozinka;
                this.korisnickoIme = korisnickoIme;
                this.email = email;
                this.datumRodjenja = datumRodjenja;
                this.profilnaSlika = profilnaSlika;
                this.opis = opis;
                this.brojTelefona = brojTelefona;
                this.prezime = prezime;
                this.ime = ime;
        }

        public KorisnikDto(String trenutnaLozinka, Set<Proizvod> prizvodi, String prezime, String ime, String brojTelefona, String opis, String profilnaSlika, String korisnickoIme, String novaLozinka, String email, Date datumRodjenja) {
                this.trenutnaLozinka = trenutnaLozinka;
                Prizvodi = prizvodi;
                this.prezime = prezime;
                this.ime = ime;
                this.brojTelefona = brojTelefona;
                this.opis = opis;
                this.profilnaSlika = profilnaSlika;
                this.korisnickoIme = korisnickoIme;
                this.novaLozinka = novaLozinka;
                this.email = email;
                this.datumRodjenja = datumRodjenja;
        }

        public String getTrenutnaLozinka() {
                return trenutnaLozinka;
        }

        public void setTrenutnaLozinka(String trenutnaLozinka) {
                this.trenutnaLozinka = trenutnaLozinka;
        }

        public String getNovaLozinka() {
                return novaLozinka;
        }

        public void setNovaLozinka(String novaLozinka) {
                this.novaLozinka = novaLozinka;
        }

        public String getKorisnickoIme() {
                return korisnickoIme;
        }

        public void setKorisnickoIme(String korisnickoIme) {
                this.korisnickoIme = korisnickoIme;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Date getDatumRodjenja() {
                return datumRodjenja;
        }

        public void setDatumRodjenja(Date datumRodjenja) {
                this.datumRodjenja = datumRodjenja;
        }

        public String getProfilnaSlika() {
                return profilnaSlika;
        }

        public void setProfilnaSlika(String profilnaSlika) {
                this.profilnaSlika = profilnaSlika;
        }

        public String getOpis() {
                return opis;
        }

        public void setOpis(String opis) {
                this.opis = opis;
        }

        public String getBrojTelefona() {
                return brojTelefona;
        }

        public void setBrojTelefona(String brojTelefona) {
                this.brojTelefona = brojTelefona;
        }

        public String getIme() {
                return ime;
        }

        public void setIme(String ime) {
                this.ime = ime;
        }

        public String getPrezime() {
                return prezime;
        }

        public Set<Proizvod> getPrizvodi() {
                return Prizvodi;
        }

        public void setPrezime(String prezime) {
                this.prezime = prezime;
        }

        // Getteri i setteri
        }


