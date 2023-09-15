package com.voronhuk.unit_tests.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.voronhuk.unit_tests.model.Pessoa;
import com.voronhuk.unit_tests.repository.PessoaRepository;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @Mock
    private PessoaRepository repository;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    @DisplayName("Salvar nova pessoa")
    void salvarPessoaSemCadastro() throws Exception {

        Pessoa pessoa = new Pessoa("Andre");

        when(repository.save(pessoa)).thenReturn(new Pessoa(Long.parseLong("2"), "Andre", 0.0));

        Pessoa pessoaSalva = pessoaService.save(pessoa);

        when(repository.findById(pessoaSalva.getId())).thenReturn(Optional.of(pessoaSalva));

        Assertions.assertEquals(pessoaSalva, pessoaService.getById(pessoaSalva.getId()));

        verify(repository, times(1)).findById(pessoaSalva.getId());
        verify(repository, times(1)).save(pessoa);
    }

    @Test
    void salvarPessoaInvalida() throws Exception {

        Pessoa pessoa = new Pessoa("");

        Assertions.assertThrows(Exception.class, () -> pessoaService.save(pessoa));

        verify(repository, never()).save(pessoa);

    }

    @Test
    void buscarPessoaInexistente() throws Exception {
        Pessoa pessoa = new Pessoa(Long.parseLong("29"), "Andre", 0.0);

        when(repository.findById(pessoa.getId())).thenReturn(Optional.empty());

        Assertions.assertThrows(Exception.class, () -> pessoaService.getById(pessoa.getId()));
    }

}
