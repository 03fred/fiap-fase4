package com.br.fiap.fase4.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fiap.fase4.model.Evaluation;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long>{

}
