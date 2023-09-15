package com.voronhuk.unit_tests.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private Double saldo;

    public void subtrairSaldo(Double valor) throws Exception {

        if (valor > saldo) {
            throw new Exception("Saldo Insuficiente");
        }

    }

    public void adicionarSaldo(Double valor) {

        saldo = saldo + valor;
    }
}
