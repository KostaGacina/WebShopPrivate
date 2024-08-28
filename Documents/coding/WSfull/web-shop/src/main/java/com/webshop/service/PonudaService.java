package com.webshop.service;

import com.webshop.model.Ponuda;
import com.webshop.repository.PonudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PonudaService {
    @Autowired
    private PonudaRepository ponudaRepository;

    public Ponuda newPonuda(Ponuda ponuda){
        return ponudaRepository.save(ponuda);
    }
}
