package com.br.fiap.fase4.interfaces.services;

import java.util.List;

import com.br.fiap.fase4.dto.EvaluationDTO;
import com.br.fiap.fase4.model.Evaluation;

public interface EvaluationService {
	void save(EvaluationDTO dto);

	List<Evaluation> getAll();
}
