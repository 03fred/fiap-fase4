package com.br.fiap.fase4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.fase4.dto.EvaluationDTO;
import com.br.fiap.fase4.interfaces.services.EvaluationService;
import com.br.fiap.fase4.model.Evaluation;

@RestController
@RequestMapping("evaluation")
public class EvaluationController {

	private EvaluationService service;

	public EvaluationController(EvaluationService service) {
		this.service = service;
	}

	@PostMapping("")
	public ResponseEntity<Void> save(@RequestBody EvaluationDTO dto) {
		this.service.save(dto);
		return ResponseEntity.status(201).build();
	}

	@GetMapping
	public ResponseEntity<List<Evaluation>> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}

}
