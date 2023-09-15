package com.voronhuk.unit_tests.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voronhuk.unit_tests.model.Pessoa;
import com.voronhuk.unit_tests.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public Pessoa getById(Long id) throws Exception {

        try {
            return repository.findById(id).get();

        } catch (Exception e) {
            throw new Exception("A pessoa com id " + id + " não foi encontrada");
        }

    }

    public void save(Pessoa remetente) {
        repository.save(remetente);
    }

}
