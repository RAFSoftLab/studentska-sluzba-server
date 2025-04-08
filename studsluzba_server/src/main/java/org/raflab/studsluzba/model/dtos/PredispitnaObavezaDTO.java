package org.raflab.studsluzba.model.dtos;

import jakarta.persistence.ManyToOne;

import org.raflab.studsluzba.model.DrziPredmet;
import org.raflab.studsluzba.model.PredispitnaObaveza;

/*
 * klasa se koristi za rezmenu podataka sa veb aplikacijom
 * pored osnovnih podatka o predispitnoj obavezu sadrzi i informaciju
 * da li za predispitnu obavezu postoje uneti poeni,
 * u kom slucaju predispitna obaveza nece moci da se obrise
 */

public class PredispitnaObavezaDTO {
	
	private Long id;
	
	private String naziv;
	private float maxBrojPoena;
	
	
	private DrziPredmet drziPredmet;
	
	private Boolean imaUnetePoene;
	
	public PredispitnaObavezaDTO() {		
	}

	public PredispitnaObavezaDTO(String naziv, float maxBrojPoena, DrziPredmet drziPredmet) {
		super();		
		this.naziv = naziv;
		this.maxBrojPoena = maxBrojPoena;
		this.drziPredmet = drziPredmet;
	}
	
	public PredispitnaObavezaDTO(PredispitnaObaveza po) {
		this.id = po.getId();
		this.naziv = po.getNaziv();
		this.maxBrojPoena = po.getMaxBrojPoena();
		this.drziPredmet = po.getDrziPredmet();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public float getMaxBrojPoena() {
		return maxBrojPoena;
	}

	public void setMaxBrojPoena(float maxBrojPoena) {
		this.maxBrojPoena = maxBrojPoena;
	}

	public DrziPredmet getDrziPredmet() {
		return drziPredmet;
	}

	public void setDrziPredmet(DrziPredmet drziPredmet) {
		this.drziPredmet = drziPredmet;
	}

	public Boolean getImaUnetePoene() {
		return imaUnetePoene;
	}

	public void setImaUnetePoene(Boolean imaUnetePoene) {
		this.imaUnetePoene = imaUnetePoene;
	}
	
	
}
