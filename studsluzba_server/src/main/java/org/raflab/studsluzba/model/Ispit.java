package org.raflab.studsluzba.model;

import java.time.LocalDate;
import java.time.LocalTime;
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
	private LocalTime vremeOdrzavanja;
	private String mestoOdrzavanja;  // ne mora da se unosi

	@ManyToOne
	private DrziPredmet drziPredmet;
	
	@ManyToOne
	private IspitniRok ispitniRok;
	
	private LocalDate datumPredajeZapisnika;
	private LocalDate datumVerifikacije;
	
		
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
	
	public LocalTime getVremeOdrzavanja() {
		return vremeOdrzavanja;
	}
	public void setVremeOdrzavanja(LocalTime vremeOdrzavanja) {
		this.vremeOdrzavanja = vremeOdrzavanja;
	}
	public DrziPredmet getDrziPredmet() {
		return drziPredmet;
	}
	public void setDrziPredmet(DrziPredmet drziPredmet) {
		this.drziPredmet = drziPredmet;
	}
	public LocalDate getDatumPredajeZapisnika() {
		return datumPredajeZapisnika;
	}
	public void setDatumPredajeZapisnika(LocalDate datumPredajeZapisnika) {
		this.datumPredajeZapisnika = datumPredajeZapisnika;
	}
	public LocalDate getDatumVerifikacije() {
		return datumVerifikacije;
	}
	public void setDatumVerifikacije(LocalDate datumVerifikacije) {
		this.datumVerifikacije = datumVerifikacije;
	}
	
	
	
	
}
