package org.raflab.studsluzba.model;

import lombok.Data;

import java.time.LocalDate;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


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
