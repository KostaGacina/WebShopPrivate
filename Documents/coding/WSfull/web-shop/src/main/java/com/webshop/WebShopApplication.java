package com.webshop;

import com.webshop.model.Kategorija;
import com.webshop.model.Korisnik;
import com.webshop.model.Ponuda;
import com.webshop.model.Proizvod;
import com.webshop.repository.KategorijaRepository;
import com.webshop.repository.KorisnikRepository;
import com.webshop.repository.PonudaRepository;
import com.webshop.repository.ProizvodRepository;
import com.webshop.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/*
   @SpringBootApplication anotacija nastala je od @EnableAutoConfiguration anotacije koja
   upravlja konfiguracijom aplikacije.
 */
@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {

	@Autowired
	private KorisnikRepository korisnikRepository;

	@Autowired
	private KategorijaRepository kategorijaRepository;

	@Autowired
	private ProizvodRepository proizvodRepository;

	@Autowired
	private PonudaRepository ponudaRepository;

	@Autowired
	private EmailService emailService;

	@Override
	public void run(String... args) {
		//emailService.sendNewMail("bozanicbane03@gmail.com", "tesrt", "tst");
	}

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}

}
