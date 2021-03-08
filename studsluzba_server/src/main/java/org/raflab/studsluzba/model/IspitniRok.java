package org.raflab.studsluzba.model;

import java.time.LocalDate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class IspitniRok {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String naziv;  // januarski, februarski
	private LocalDate datumPocetka;
	private LocalDate datumZavrsetka;
	private LocalDate datumPocetkaPrijave;   // ako se prebacimo na prijavu svih ispita u odredjenom periodu
 	private LocalDate datumZavrsetkaPrijave;
 	@ManyToOne
 	private SkolskaGodina skolskaGodina;
 	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public LocalDate getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(LocalDate datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public LocalDate getDatumZavrsetka() {
		return datumZavrsetka;
	}
	public void setDatumZavrsetka(LocalDate datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}
	public LocalDate getDatumPocetkaPrijave() {
		return datumPocetkaPrijave;
	}
	public void setDatumPocetkaPrijave(LocalDate datumPocetkaPrijave) {
		this.datumPocetkaPrijave = datumPocetkaPrijave;
	}
	public LocalDate getDatumZavrsetkaPrijave() {
		return datumZavrsetkaPrijave;
	}
	public void setDatumZavrsetkaPrijave(LocalDate datumZavrsetkaPrijave) {
		this.datumZavrsetkaPrijave = datumZavrsetkaPrijave;
	}
	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}
	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
 	
 	
	
	
}
