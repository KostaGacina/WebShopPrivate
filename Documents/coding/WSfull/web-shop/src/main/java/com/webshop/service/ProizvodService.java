package com.webshop.service;

import com.webshop.dto.ProizvodDto;

import com.webshop.dto.SearchDto;
import com.webshop.model.Kategorija;
import com.webshop.model.Korisnik;
import com.webshop.model.Ponuda;
import com.webshop.model.Proizvod;
import com.webshop.repository.KategorijaRepository;
import com.webshop.repository.KorisnikRepository;
import com.webshop.repository.PonudaRepository;
import com.webshop.repository.ProizvodRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.*;


@Service
public class ProizvodService {

    @Autowired
    private ProizvodRepository proizvodRepository;

    @Autowired
    private PonudaService ponudaService;

    public Page<ProizvodDto> getProizvodi(int brstr, int velstr) {

        Pageable stranica = PageRequest.of(brstr, velstr);

        Page<ProizvodDto> proizvodi = proizvodRepository.findAllPageable(stranica);

        return proizvodi;

    }

    public Optional<Proizvod> getProizvod(Long id) {

        return proizvodRepository.findById(id);

    }

    public Page<ProizvodDto> proizvodiSearchOrFilter(SearchDto filteri, int brstr){
        String flagStr = filteri.getFlagovi();
        Pageable str = PageRequest.of(brstr, 10);
        switch (flagStr){
            case "00000"://32
                Page<ProizvodDto> proizvodi = proizvodRepository.findAllPageable(str);
                return proizvodi;
            case "00001"://31
                Page<ProizvodDto> strProizvodaPoTipiProdaje = proizvodRepository.findByTipProdaje(filteri.getTipP(), str);
                return strProizvodaPoTipiProdaje;
            case "00010"://30
                Page<ProizvodDto> strProizvodaPoKategoriji = proizvodRepository.findByKategorija(filteri.getKategorija(), str);
                return strProizvodaPoKategoriji;
            case "00011"://29
                Page<ProizvodDto> strProizvodaPoTipuProdajeIPoKategoriji = proizvodRepository.findByTipProdajeAndKategorija(filteri.getTipP(), filteri.getKategorija(), str);
                return strProizvodaPoTipuProdajeIPoKategoriji;
            case "00100"://28
                Page<ProizvodDto> strProizvodaCenaManjaOd= proizvodRepository.findByCenaLeCenaDo(filteri.getCenado(), str);
                return strProizvodaCenaManjaOd;
            case "00101"://27
                Page<ProizvodDto> strProizvodaCenaManjaOdIPoTipuProdaje= proizvodRepository.findByCenaLeCenaDoAndTipProdaje(filteri.getCenado(), filteri.getTipP(), str);
                return strProizvodaCenaManjaOdIPoTipuProdaje;
            case "00110"://26
                Page<ProizvodDto> strProizvodaCenaManjaOdIPoKategoriji= proizvodRepository.findByCenaLeCenaDoAndKategorija(filteri.getCenado(), filteri.getKategorija(), str);
                return strProizvodaCenaManjaOdIPoKategoriji;//------------
            case "00111"://25
                Page<ProizvodDto> strProizvodaCenaManjaOdIPoKategorijiIPoTipuProdaje= proizvodRepository.findByCenaLeCenaDoAndKategorijaAndTipProdaje(filteri.getCenado(), filteri.getKategorija(), filteri.getTipP(), str);
                return strProizvodaCenaManjaOdIPoKategorijiIPoTipuProdaje;
            case "01000"://24
                Page<ProizvodDto> strProizvodaCenaVecaOd= proizvodRepository.findByCenaGeCenaOd(filteri.getCenaod(), str);
                return strProizvodaCenaVecaOd;
            case "01001"://23
                Page<ProizvodDto> strProizvodaCenaVecaOdITipProdaje= proizvodRepository.findByCenaGeCenaOdAndTipPRodaje(filteri.getCenaod(), filteri.getTipP(), str);
                return strProizvodaCenaVecaOdITipProdaje;
            case "01010"://22
                Page<ProizvodDto> strProizvodaCenaVecaOdIKategorija= proizvodRepository.findByCenaGeCenaOdAndKategorija(filteri.getCenaod(), filteri.getKategorija(), str);
                return strProizvodaCenaVecaOdIKategorija;
            case "01011"://21
                Page<ProizvodDto> strProizvodaCenaVecaOdIKategorijaITipProdaje= proizvodRepository.findByCenaGeCenaOdAndKategorijaAndTipProdaje(filteri.getCenaod(), filteri.getKategorija(), filteri.getTipP(), str);
                return strProizvodaCenaVecaOdIKategorijaITipProdaje;
            case "01100"://20
                Page<ProizvodDto> strProizvodaCenaIzmedju= proizvodRepository.findByCenaBetween(filteri.getCenaod(), filteri.getCenado(), str);
                return strProizvodaCenaIzmedju;
            case "01101"://19
                Page<ProizvodDto> strProizvodaCenaIzmedjuITipProdaje = proizvodRepository.findByCenaBetweenAndTipProdaje(filteri.getCenaod(), filteri.getCenado(), filteri.getTipP(), str);
                return strProizvodaCenaIzmedjuITipProdaje;
            case "01110"://18
                Page<ProizvodDto> strProizvodaCenaIzmedjuIKategorija = proizvodRepository.findByCenaBetweenAndKategorija(filteri.getCenaod(), filteri.getCenado(), filteri.getKategorija(), str);
                return strProizvodaCenaIzmedjuIKategorija;
            case "01111"://17
                Page<ProizvodDto> strProizvodaCenaIzmedjuIKategorijaITipProdaje = proizvodRepository.findByCenaBetweenAndKategorijaAndTipProdaje(filteri.getCenaod(), filteri.getCenado(), filteri.getKategorija(), filteri.getTipP(), str);
                return strProizvodaCenaIzmedjuIKategorijaITipProdaje;
            case "10000"://16
                Page<ProizvodDto> strProizvodaNazivIOpis = proizvodRepository.findByNazivOrOpis(filteri.getImeopis(), str);
                return strProizvodaNazivIOpis;
            case "10001"://15
                Page<ProizvodDto> strProizvodaNazivIOpisITipProdaje = proizvodRepository.findByNazivOrOpisAndTipProdaje(filteri.getImeopis(), filteri.getTipP(), str);
                return strProizvodaNazivIOpisITipProdaje;
            case "10010"://14
                Page<ProizvodDto> strProizvodaNazivIOpisIKategorija = proizvodRepository.findByNazivOrOpisAndKategorija(filteri.getImeopis(), filteri.getKategorija(), str);
                return strProizvodaNazivIOpisIKategorija;
            case "10011"://13
                Page<ProizvodDto> strProizvodaNazivIOpisIKategorijaITipProdaje = proizvodRepository.findByNazivOrOpisAndKategorijaAndTipProdaje(filteri.getImeopis(), filteri.getKategorija(), filteri.getTipP(), str);
                return strProizvodaNazivIOpisIKategorijaITipProdaje;
            case "10100"://12
                Page<ProizvodDto> strProizvodaNazivIOpisICenaLeCenaDo = proizvodRepository.findByNazivOrOpisAndLtCenaDo(filteri.getImeopis(), filteri.getCenado(), str);
                return strProizvodaNazivIOpisICenaLeCenaDo;
            case "10101"://11
                Page<ProizvodDto> strProizvodaNazivIOpisICenaLeCenaDoAndTipProdaje = proizvodRepository.findByNazivOrOpisAndLtCenaDoAndTipProdaje(filteri.getImeopis(), filteri.getCenado(), filteri.getTipP(), str);
                return strProizvodaNazivIOpisICenaLeCenaDoAndTipProdaje;
            case "10110"://10
                Page<ProizvodDto> strProizvodaNazivIOpisICenaLeCenaDoAndKategorija = proizvodRepository.findByNazivOrOpisAndLtCenaDoAndKategorija(filteri.getImeopis(), filteri.getCenado(), filteri.getKategorija(), str);
                return strProizvodaNazivIOpisICenaLeCenaDoAndKategorija;
            case "10111"://9
                Page<ProizvodDto> strProizvodaNazivIOpisICenaLeCenaDoAndKategorijaAndTipProdaje = proizvodRepository.findByNazivOrOpisAndLtCenaDoAndKategorijaAndTipProdaje(filteri.getImeopis(), filteri.getCenado(), filteri.getKategorija(), filteri.getTipP(), str);
                return strProizvodaNazivIOpisICenaLeCenaDoAndKategorijaAndTipProdaje;
            case "11000"://8
                Page<ProizvodDto> strProizvodaNazivIOpisICenaGeCenaOd = proizvodRepository.findByNazivOrOpisAndGtCenaOd(filteri.getImeopis(), filteri.getCenaod(), str);
                return strProizvodaNazivIOpisICenaGeCenaOd;
            case "11001"://7
                Page<ProizvodDto> strProizvodaNazivIOpisICenaGeCenaOdITipProdaje = proizvodRepository.findByNazivOrOpisAndGtCenaOdAndTipProdaje(filteri.getImeopis(), filteri.getCenaod(), filteri.getTipP(), str);
                return strProizvodaNazivIOpisICenaGeCenaOdITipProdaje;
            case "11010"://6
                Page<ProizvodDto> strProizvodaNazivIOpisICenaGeCenaOdIKategorija = proizvodRepository.findByNazivOrOpisAndGtCenaOdAndKategorija(filteri.getImeopis(), filteri.getCenaod(), filteri.getKategorija(),  str);
                return strProizvodaNazivIOpisICenaGeCenaOdIKategorija;
            case "11011"://5
                Page<ProizvodDto> strProizvodaNazivIOpisICenaGeCenaOdIKategorijaITipProdaje = proizvodRepository.findByNazivOrOpisAndGtCenaOdAndKategorijaAndTipProdaje(filteri.getImeopis(), filteri.getCenaod(), filteri.getKategorija(), filteri.getTipP(),  str);
                return strProizvodaNazivIOpisICenaGeCenaOdIKategorijaITipProdaje;
            case "11100"://4
                Page<ProizvodDto> strProizvodaNazivIOpisICenaIzmedju = proizvodRepository.findByNazivOrOpisAndCenaBetween(filteri.getImeopis(), filteri.getCenaod(), filteri.getCenado(),  str);
                return strProizvodaNazivIOpisICenaIzmedju;
            case "11101"://3
                Page<ProizvodDto> strProizvodaNazivIOpisICenaIzmedjuAndTipProdaje = proizvodRepository.findByNazivOrOpisAndCenaBetweenAndTipProdaje(filteri.getImeopis(), filteri.getCenaod(), filteri.getCenado(), filteri.getTipP(),  str);
                return strProizvodaNazivIOpisICenaIzmedjuAndTipProdaje;
            case "11110"://2
                Page<ProizvodDto> strProizvodaNazivIOpisICenaIzmedjuAndKategorija = proizvodRepository.findByNazivOrOpisAndCenaBetweenAndKategorija(filteri.getImeopis(), filteri.getCenaod(), filteri.getCenado(), filteri.getKategorija(),  str);
                return strProizvodaNazivIOpisICenaIzmedjuAndKategorija;
            case "11111"://1
                Page<ProizvodDto> strProizvodaNazivIOpisICenaIzmedjuAndKategorijaAndTipProdaje = proizvodRepository.findByNazivOrOpisAndCenaBetweenAndKategorijaAndTipProdaje(filteri.getImeopis(), filteri.getCenaod(), filteri.getCenado(), filteri.getKategorija(), filteri.getTipP(),  str);
                return strProizvodaNazivIOpisICenaIzmedjuAndKategorijaAndTipProdaje;
            default:
                return null;
        }

    }

    @Autowired
    private KategorijaRepository kategorijaRepository;
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Proizvod postaviProizvodNaProdaju(ProizvodDto proizvodDto, Long id) {
        Kategorija kategorija = kategorijaRepository.findByNaziv(proizvodDto.getKategorija().getNaziv());
        if (kategorija == null) {
            kategorija = new Kategorija();
            kategorija.setNaziv(proizvodDto.getKategorija().getNaziv());
            kategorijaRepository.save(kategorija);
        }
        /*System.out.println(proizvodDto.getProdavacId());
        System.out.println(proizvodDto.getId());
        System.out.println(proizvodDto.getOpis());
        System.out.println(proizvodDto.getNaziv());*/
        Korisnik prodavac = korisnikRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Prodavac sa ID-jem " + proizvodDto.getProdavacId() + " ne postoji."));

        Proizvod proizvod = new Proizvod();
        proizvod.setNaziv(proizvodDto.getNaziv());
        proizvod.setOpis(proizvodDto.getOpis());
        proizvod.setSlika(proizvodDto.getSlika());
        proizvod.setCena(proizvodDto.getCena());
        proizvod.setKategorija(kategorija);
        proizvod.setTipProdaje(proizvodDto.getTipProdaje());
        proizvod.setProdavac(prodavac);
        proizvod.setDatumObjavljivanja(new Date());

        kategorijaRepository.save(kategorija);
        proizvodRepository.save(proizvod);
        prodavac.getPrizvodi().add(proizvod);
        korisnikRepository.save(prodavac);

        return proizvod;
    }

    @Autowired
    private EmailService emailService;

    public Proizvod proglasiKrajAukcije(Long proizvodId){  //Da bi testirao treba da se implementir kupovina proizvoda metoda od kupca
        Proizvod proizvod = proizvodRepository.findById(proizvodId).orElseThrow(() ->
                new IllegalArgumentException("Proizvod sa ID-em " + proizvodId + " ne postoji"));

        if(!proizvod.getTipProdaje().equals(Proizvod.tipprodaje.aukcija)){
            throw new IllegalArgumentException("Proizvod sa ID-em " + proizvodId + " nije na aukciji");
        }

        if (proizvod.getPonude().isEmpty()){
            throw new IllegalArgumentException("Nema ponuda za proizvod sa ID-em " + proizvodId);
        }

       Ponuda poslednjaPonuda = proizvod.getPonude().stream()
               .max(Comparator.comparing(Ponuda::getCena))
               .orElseThrow(() -> new IllegalArgumentException("Greska pri pronalazenju poslednje ponude"));

       Korisnik kupac = poslednjaPonuda.getKupacKojiJeDaoPonudu();
       Korisnik prodavac = proizvod.getProdavac();

        kupac.getPrizvodi().add(proizvod);
        prodavac.getPrizvodi().remove(proizvod);
        proizvod.setProdat(true);


        korisnikRepository.save(prodavac);
        korisnikRepository.save(kupac);
        proizvodRepository.save(proizvod);

        System.out.println("puca pre ovog");

        String subject = "Aukcija završena";
        String body = "Aukcija za proizvod " + proizvod.getNaziv() + " je završena. Pobednik je " + kupac.getIme() + " " + kupac.getPrezime() + " sa ponudom od " + poslednjaPonuda.getCena() + " dinara.";
        emailService.sendNewMail(kupac.getMejlAdresa(), subject, body);
        emailService.sendNewMail(prodavac.getMejlAdresa(), subject, body);

        return proizvod;
    }

    public Proizvod azurirajProizvod(Long id, ProizvodDto azuriraniProizvod){
        Proizvod proizvod = proizvodRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Proizvod sa ID-em " + id + " ne postoji"));

        if (proizvod.getProdavac().getUloga() != Korisnik.TipKorisnika.Prodavac){
            throw new IllegalArgumentException("Samo prodavac sme da azurira proizvod");
        }

        if (proizvod.getTipProdaje().equals(Proizvod.tipprodaje.aukcija) && !proizvod.getPonude().isEmpty()) {
            throw new IllegalArgumentException("Proizvod se ne može izmeniti jer postoji aktivna ponuda na aukciji.");
        }

        Kategorija kategorija = azuriraniProizvod.getKategorija();
        if (kategorija != null) {
            kategorija = kategorijaRepository.findById(kategorija.getId())
                    .orElse(kategorijaRepository.save(kategorija));
            proizvod.setKategorija(kategorija);
        }
        if (azuriraniProizvod.getNaziv() != null) {
            proizvod.setNaziv(azuriraniProizvod.getNaziv());
        }
        if (azuriraniProizvod.getOpis() != null) {
            proizvod.setOpis(azuriraniProizvod.getOpis());
        }
        if (azuriraniProizvod.getSlika() != null) {
            proizvod.setSlika(azuriraniProizvod.getSlika());
        }
        if (azuriraniProizvod.getCena() != null) {
            proizvod.setCena(azuriraniProizvod.getCena());
        }
        if (azuriraniProizvod.getTipProdaje() != null) {
            proizvod.setTipProdaje(azuriraniProizvod.getTipProdaje());
        }

        proizvodRepository.save(proizvod);

        return proizvod;
    }

    public boolean obavljenaTrgovinaFiksnaCena(Proizvod proizvod, Korisnik korisnik) {
        if(proizvod.getProdavac() == null) return false;
        proizvod.setProdat(true);
        if(save(proizvod) == null) return false;
        korisnik.getPrizvodi().add(proizvod);
        proizvod.getProdavac().getPrizvodi().remove(proizvod);
        if (korisnikRepository.save(korisnik) == null) return false;
        if (korisnikRepository.save(proizvod.getProdavac()) == null) return false;

        return true;

    }

    public boolean novaPonuda(Proizvod proizvod, Korisnik korisnik, BigDecimal ponuda){
        if(ponuda.compareTo(proizvod.getCena()) == -1 || proizvod.isProdat() ) return false;

        Ponuda ponudaObj = new Ponuda(ponuda, korisnik);
        proizvod.setCena(ponuda);
        proizvod.getPonude().add(ponudaObj);

        return ponudaService.newPonuda(ponudaObj) != null && save(proizvod) != null;
    }

    public Korisnik findKorisnikKojiJeKupioProizovd(Proizvod proizvod) {
        List<Korisnik> korisnici = korisnikRepository.findAll();

        for(Korisnik k : korisnici) {
            if(k.getPrizvodi().contains(proizvod)) {
                return k;
            }
        }

        return null;
    }

    public Proizvod save(Proizvod proizvod){
       return proizvodRepository.save(proizvod);
    }

}
