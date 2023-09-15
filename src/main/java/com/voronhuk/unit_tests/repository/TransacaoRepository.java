package com.voronhuk.unit_tests.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.voronhuk.unit_tests.model.Transacao;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
}
