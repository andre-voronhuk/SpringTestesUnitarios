package com.voronhuk.unit_tests.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voronhuk.unit_tests.model.Pessoa;
import com.voronhuk.unit_tests.model.Transacao;
import com.voronhuk.unit_tests.repository.TransacaoRepository;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private PessoaService pessoaService;

    public void transferirDinheiro(Long idRemetente, Long idDestinatario, Double valor) throws Exception {

        Pessoa remetente = pessoaService.getById(idRemetente);
        Pessoa destinatario = pessoaService.getById(idDestinatario);

        remetente.subtrairSaldo(valor);
        pessoaService.save(remetente);

        destinatario.adicionarSaldo(valor);
        pessoaService.save(destinatario);

        Transacao transacao = new Transacao(idRemetente, idDestinatario, valor);
        this.save(transacao);
    }

    private void save(Transacao transacao) {
        this.repository.save(transacao);
    }

}
