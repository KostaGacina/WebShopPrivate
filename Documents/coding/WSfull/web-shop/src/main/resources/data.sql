INSERT INTO Kategorija(naziv) values ('Komjuterske periferije');
INSERT INTO Kategorija(naziv) values ('higijena');
INSERT INTO Kategorija(naziv) values ('aksesoari');

INSERT INTO Proizvod (naziv, opis, slika, cena, datum_objavljivanja, ostavljenja_recenzija_od_strane_kupca, ostavljenja_recenzija_od_strane_prodavca, prodat, kategorija_id, tip_prodaje) VALUES ('Komjuterski mis', 'stanje odlicno', '#', 250.0, '2023-02-05', 0, 0, 0, 1, 0);
INSERT INTO Proizvod (naziv, opis, slika, cena, datum_objavljivanja, ostavljenja_recenzija_od_strane_kupca, ostavljenja_recenzija_od_strane_prodavca, prodat, kategorija_id, tip_prodaje) VALUES ('prozorkso okno', 'drvo', '#', 10000.0, '2022-01-04', 0, 0, 0, 2, 1);
INSERT INTO Proizvod (naziv, opis, slika, cena, datum_objavljivanja, ostavljenja_recenzija_od_strane_kupca, ostavljenja_recenzija_od_strane_prodavca, prodat, kategorija_id, tip_prodaje) VALUES ('ceger', 'platneni', '#', 50.0, '2024-02-05', 0, 0, 0, 3, 0);
INSERT INTO Proizvod (naziv, opis, slika, cena, datum_objavljivanja, ostavljenja_recenzija_od_strane_kupca, ostavljenja_recenzija_od_strane_prodavca, prodat, kategorija_id, tip_prodaje) VALUES ('flasica', 'plastika', 'https://imgur.com/gallery/flasica-vgY3QXk', 300.0, '2024-02-05', 0, 0, 0, 3, 0);

INSERT INTO Prijava_profila (razlog_prijave, datum_podnosenja_prijave, status_prijave) VALUES ('Neprofesionalnost', '2024-02-02', 0);
INSERT INTO Prijava_profila (razlog_prijave, datum_podnosenja_prijave, status_prijave) VALUES ('laze', '2024-02-02', 0);
INSERT INTO Prijava_profila (razlog_prijave, datum_podnosenja_prijave, status_prijave) VALUES ('neprecizan', '2024-02-02', 0);

INSERT INTO Korisnik (ime, prezime, korisnicko_ime, mejl_adresa, broj_telefona, lozinka, datum_rodjenja, putanja_do_slike, opis, blokiran,uloga, prosecna_ocena)
VALUES ('John', 'Doe', 'johndoe', 'john@example.com', '123456789', 'password', '1990-05-15', '/path/to/image', 'Description', false, 1, 0.0);
INSERT INTO Korisnik (ime, prezime, korisnicko_ime, mejl_adresa, broj_telefona, lozinka, datum_rodjenja, putanja_do_slike, opis, blokiran,uloga, prosecna_ocena)
VALUES ('Bill', 'Lincoln', 'bigbilly', 'bbilly@example.com', '123456889', 'password2', '1990-05-15', '/path/to/image', 'Description', false, 1, 0.0);
INSERT INTO Korisnik (ime, prezime, korisnicko_ime, mejl_adresa, broj_telefona, lozinka, datum_rodjenja, putanja_do_slike, opis, blokiran,uloga, prosecna_ocena)
VALUES ('Mark', 'Hunter', 'mrkhunter', 'mark@example.com', '123496789', 'password3', '1987-08-12', '/path/to/image', 'Description', false, 0, 0.0);
INSERT INTO Korisnik (ime, prezime, korisnicko_ime, mejl_adresa, broj_telefona, lozinka, datum_rodjenja, putanja_do_slike, opis, blokiran,uloga, prosecna_ocena)
VALUES ('Bane', 'Bozanic', 'baneadmin', 'admin@webshop.com', '21354878', 'admin', '2003-04-25', '/path/to/image', 'nema', false, 2, 0.0);

INSERT INTO Ponuda (Cena, kupac_id) VALUES (150.0, 1);
INSERT INTO Ponuda (Cena, kupac_id) VALUES (350.0, 3);
INSERT INTO Ponuda (Cena, kupac_id) VALUES (250, 2);

INSERT INTO Recenzija (ocena, komentar, datum_recenzije, korisnik_id) VALUES (5.4,'korektan','2024-04-09',1);
INSERT INTO Recenzija (ocena, komentar, datum_recenzije, korisnik_id) VALUES (5.4,'korektan','2024-04-09',1);
INSERT INTO Recenzija (ocena, komentar, datum_recenzije, korisnik_id) VALUES (5.4,'korektan','2024-04-09',1);

--INSERT INTO PrijavaProfila (razlogPrijave,datumPodnosenjaPrijave, korisnik_podneo_prijavu_id,korisnik_prijavljen_id,statusPrijave)
--VALUES ('nepristojan','2024-05-09',2,1,0);

