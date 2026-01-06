package com.br.fiap.fase4.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.core.util.BinaryData;
import com.azure.messaging.eventgrid.EventGridEvent;
import com.azure.messaging.eventgrid.EventGridPublisherClient;
import com.br.fiap.fase4.dto.EvaluationDTO;
import com.br.fiap.fase4.interfaces.services.EvaluationService;
import com.br.fiap.fase4.model.Evaluation;

@RestController
@RequestMapping("evaluation")
public class EvaluationController {

	private EvaluationService service;
    private final EventGridPublisherClient<EventGridEvent> client;
    
	public EvaluationController(EvaluationService service, EventGridPublisherClient<EventGridEvent> client) {
		this.service = service;
		this.client = client;
	}

	@PostMapping("")
	public ResponseEntity<Void> save(@RequestBody EvaluationDTO dto) {
		this.service.save(dto);
		
		EventGridEvent event = new EventGridEvent(
                "evaluation",
                "EvaluationCreated",
                 BinaryData.fromObject(dto),
                "1.0"
        );

        client.sendEvent(event);
        
		return ResponseEntity.status(201).build();
	}

	@GetMapping
	public ResponseEntity<List<Evaluation>> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}

}
