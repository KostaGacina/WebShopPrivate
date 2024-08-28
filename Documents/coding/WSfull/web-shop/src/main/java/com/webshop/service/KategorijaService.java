package com.webshop.service;

import com.webshop.model.Kategorija;
import com.webshop.repository.KategorijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategorijaService {

    @Autowired
    private KategorijaRepository kategorijaRepository;

    public List<Kategorija> findAll() {
        return kategorijaRepository.findAll();
    }

    public Kategorija findById(Long id) {
        return kategorijaRepository.findById(id).orElse(null);
    }

}
