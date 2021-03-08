package org.raflab.studsluzba.model;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SkolskaGodina {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int pocetna;
	private int krajnja;
	private boolean aktivna;
	
	public int getPocetna() {
		return pocetna;
	}
	public void setPocetna(int pocetna) {
		this.pocetna = pocetna;
		this.krajnja = pocetna+1;
	}
	public int getKrajnja() {
		return krajnja;
	}
	
	public boolean isAktivna() {
		return aktivna;
	}
	public void setAktivna(boolean aktivna) {
		this.aktivna = aktivna;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setKrajnja(int krajnja) {
		this.krajnja = krajnja;
	}
	
	
}
