package com.voronhuk.unit_tests.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.voronhuk.unit_tests.repository.TransacaoRepository;

public class TransacaoServiceTest {

    @InjectMocks
    private TransacaoService transacaoService;

    @Mock
    private TransacaoRepository repository;

    @Mock
    private PessoaService pessoaService;

}
