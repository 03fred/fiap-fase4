package com.br.fiap.fase4.services;

import org.springframework.stereotype.Service;

import com.br.fiap.fase4.dto.EvaluationDTO;
import com.br.fiap.fase4.interfaces.repository.EvaluationRepository;
import com.br.fiap.fase4.interfaces.services.EvaluationService;
import com.br.fiap.fase4.model.Evaluation;

@Service
public class EvaluationServiceImpl implements EvaluationService {

	private EvaluationRepository repository;

	public EvaluationServiceImpl(EvaluationRepository repository) {
		this.repository = repository;
	}

	public void save(EvaluationDTO dto) {

		 Evaluation model = new Evaluation(dto);
		 this.repository.save(model);
	}
}
