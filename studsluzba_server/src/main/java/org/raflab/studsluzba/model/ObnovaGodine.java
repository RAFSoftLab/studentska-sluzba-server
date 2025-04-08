package org.raflab.studsluzba.model;

import lombok.Data;

import java.time.LocalDate;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
@Data
public class ObnovaGodine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private StudentIndeks studentIndeks;
	
	private Integer godinaKojuObnavlja;	
	
	@ManyToMany
	private List<Predmet> upisujePredmete;
	
	private LocalDate datumObnove;	
	
	private String napomena;
	
	@ManyToOne
	private SkolskaGodina skolskaGodina;
}
