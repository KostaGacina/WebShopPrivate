package com.webshop.controller;

import com.webshop.model.Korisnik;
import com.webshop.model.Ponuda;
import com.webshop.model.Proizvod;
import com.webshop.service.KorisnikService;
import com.webshop.service.PonudaService;
import com.webshop.service.ProizvodService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController("/api/offer")
public class PonudaRestController {

    @Autowired
    private PonudaService ponudaService;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private ProizvodService proizvodService;

}
