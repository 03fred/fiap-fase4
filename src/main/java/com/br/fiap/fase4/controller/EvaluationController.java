package com.br.fiap.fase4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.fase4.dto.EvaluationDTO;
import com.br.fiap.fase4.interfaces.services.EvaluationService;


@RestController
@RequestMapping("evaluation")
public class EvaluationController {
	
	private EvaluationService service;
	
	public EvaluationController (EvaluationService service) {
	   this.service = service;	
	}
	
	@PostMapping("")
	public ResponseEntity<Void> save(@RequestBody EvaluationDTO dto) {
		this.service.save(dto);
		return ResponseEntity.status(201).build();
	}
	

}
