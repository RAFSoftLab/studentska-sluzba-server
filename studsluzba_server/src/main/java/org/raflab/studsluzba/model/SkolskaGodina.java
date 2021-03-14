package org.raflab.studsluzba.model;



import java.time.LocalDate;

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
	
	private LocalDate datumPocetka;
	
	
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
	public LocalDate getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(LocalDate datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	
	
}
