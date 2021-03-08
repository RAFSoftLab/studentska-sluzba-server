package org.raflab.studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class IzlazakIspit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private PrijavaIspita prijava;
	private Float brojPoenaIspit;
	private Float brojPoenaPredispitne;  // automatski se sabira, ne unosi se
	private boolean ponisten = false;
	private String napomena;
	
	public PrijavaIspita getPrijava() {
		return prijava;
	}
	public void setPrijava(PrijavaIspita prijava) {
		this.prijava = prijava;
	}
	public float getBrojPoenaIspit() {
		return brojPoenaIspit;
	}
	public void setBrojPoenaIspit(float brojPoenaIspit) {
		this.brojPoenaIspit = brojPoenaIspit;
	}
	public float getBrojPoenaPredispitne() {
		return brojPoenaPredispitne;
	}
	public void setBrojPoenaPredispitne(float brojPoenaPredispitne) {
		this.brojPoenaPredispitne = brojPoenaPredispitne;
	}
	public boolean isPonisten() {
		return ponisten;
	}
	public void setPonisten(boolean ponisten) {
		this.ponisten = ponisten;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	
	
	
}
