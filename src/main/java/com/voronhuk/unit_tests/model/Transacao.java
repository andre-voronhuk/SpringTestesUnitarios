package com.voronhuk.unit_tests.model;

import java.text.SimpleDateFormat;
import java.util.Date;

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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private Long remetente;
    @Column
    private Long destinatario;
    @Column
    private Double valor;
    @Column
    private String timestamp;

    public Transacao(Long idRemetente, Long idDestinatario, Double valor) {
        this.remetente = idRemetente;
        this.destinatario = idDestinatario;
        this.valor = valor;
        this.timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }

}
