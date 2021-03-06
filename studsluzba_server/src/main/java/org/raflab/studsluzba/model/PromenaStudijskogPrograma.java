package org.raflab.studsluzba.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PromenaStudijskogPrograma {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private StudentIndeks stariIndeks;
	@ManyToOne
	private StudentIndeks noviIndeks;
	
	private LocalDate datum;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public StudentIndeks getStariIndeks() {
		return stariIndeks;
	}
	public void setStariIndeks(StudentIndeks stariIndeks) {
		this.stariIndeks = stariIndeks;
	}
	public StudentIndeks getNoviIndeks() {
		return noviIndeks;
	}
	public void setNoviIndeks(StudentIndeks noviIndeks) {
		this.noviIndeks = noviIndeks;
	}
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	
	
	
	
}
