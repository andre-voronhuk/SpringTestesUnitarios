package com.voronhuk.unit_tests.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import com.voronhuk.unit_tests.model.Pessoa;
import com.voronhuk.unit_tests.model.Transacao;
import com.voronhuk.unit_tests.repository.TransacaoRepository;

public class TransacaoServiceTest {

    @InjectMocks
    private TransacaoService transacaoService;

    @Mock
    private TransacaoRepository repository;

    @Mock
    private PessoaService pessoaService;

    @Test
    void transferenciaOk() throws Exception {
        // TODO Terminar
        Long idRemetente = 1L;
        Long idDestinatario = 2L;
        Double valor = 2.0;

        Pessoa remetente = new Pessoa("John");
        remetente.adicionarSaldo(10.0);

        Pessoa destinatario = new Pessoa("Lucas");

        when(pessoaService.getById(idRemetente)).thenReturn(remetente);
        when(pessoaService.getById(idDestinatario)).thenReturn(destinatario);

        transacaoService.transferirDinheiro(idRemetente, idDestinatario, valor);

        Assertions.assertEquals(8.0, remetente.getSaldo());
        Assertions.assertEquals(2.0, destinatario.getSaldo());

        verify(repository, times(1)).save(any(Transacao.class));
    }

}