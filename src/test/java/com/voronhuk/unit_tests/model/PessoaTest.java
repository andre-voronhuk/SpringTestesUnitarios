package com.voronhuk.unit_tests.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.util.Assert;

public class PessoaTest {

    @InjectMocks
    private Pessoa pessoa;

    @Test
    void adicionarDinheiro() {
        Pessoa pessoa = new Pessoa("Andre");

        pessoa.adicionarSaldo(100.0);
        Assertions.assertEquals(100.0, pessoa.getSaldo());

        pessoa.adicionarSaldo(1.0);
        Assertions.assertEquals(101.0, pessoa.getSaldo());

    }

    @Test
    void subtrairValorMaiorQueOSaldo() throws Exception {
        Pessoa pessoa = new Pessoa("Andre");

        Assertions.assertThrows(Exception.class, () -> pessoa.subtrairSaldo(100.0));

    }

}
