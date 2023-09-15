package com.voronhuk.unit_tests.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Pessoa")
@Getter
@Setter
@AllArgsConstructor
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
        this.saldo = this.saldo - valor;

    }

    public Pessoa(String nome) {
        this.id = null;
        this.saldo = 0.0;
        this.nome = nome;
    }

    public Pessoa() {
        this.saldo = 0.0;
        this.id = null;

    }

    public void adicionarSaldo(Double valor) {

        this.saldo = this.saldo + valor;
    }
}
