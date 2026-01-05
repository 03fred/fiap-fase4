package com.br.fiap.fase4.model;

import java.util.Date;

import com.br.fiap.fase4.dto.EvaluationDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor                     
@Entity                               
@Table(name = "evaluation")
public class Evaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private int note;
	
    @Column(name = "dt_evaluation")
    private Date dtCreateRow;
	
	public Evaluation( EvaluationDTO dto) {
		this.description = dto.description();
		this.note = dto.note();
		this.dtCreateRow = new Date();
	}

}
