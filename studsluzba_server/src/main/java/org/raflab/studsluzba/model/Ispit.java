package org.raflab.studsluzba.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ispit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate datumOdrzavanja;    // i vreme
	private String mestoOdrzavanja;  // ne mora da se unosi
	private boolean zakljucen;
	@ManyToOne
	private Predmet predmet;
	@ManyToOne
	private Nastavnik nastavnik;
	@ManyToOne
	private IspitniRok ispitniRok;
	@OneToMany
	private Set<PrijavaIspita> prijave;
	
	public LocalDate getDatumOdrzavanja() {
		return datumOdrzavanja;
	}
	public void setDatumOdrzavanja(LocalDate datumOdrzavanja) {
		this.datumOdrzavanja = datumOdrzavanja;
	}
	public String getMestoOdrzavanja() {
		return mestoOdrzavanja;
	}
	public void setMestoOdrzavanja(String mestoOdrzavanja) {
		this.mestoOdrzavanja = mestoOdrzavanja;
	}
	public boolean isZakljucen() {
		return zakljucen;
	}
	public void setZakljucen(boolean zakljucen) {
		this.zakljucen = zakljucen;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public Nastavnik getNastavnik() {
		return nastavnik;
	}
	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}
	public IspitniRok getIspitniRok() {
		return ispitniRok;
	}
	public void setIspitniRok(IspitniRok ispitniRok) {
		this.ispitniRok = ispitniRok;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<PrijavaIspita> getPrijave() {
		return prijave;
	}
	public void setPrijave(Set<PrijavaIspita> prijave) {
		this.prijave = prijave;
	}
	
	
	
	
}
