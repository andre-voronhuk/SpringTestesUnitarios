package com.voronhuk.unit_tests.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voronhuk.unit_tests.service.PessoaService;
import com.voronhuk.unit_tests.service.TransacaoService;

@RestController
public class AppController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping(value = "/")
    public ResponseEntity<String> getMain(@RequestParam String param) throws NumberFormatException, Exception {
        pessoaService.getById(Long.parseLong("0"));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
