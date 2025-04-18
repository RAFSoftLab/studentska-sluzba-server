package org.raflab.studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class DrziPredmet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private SkolskaGodina skolskaGodina;
	
	@ManyToOne
	private Nastavnik nastavnik;
	
	@ManyToOne
	private Predmet predmet;
}
