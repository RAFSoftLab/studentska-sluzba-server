package org.raflab.studsluzba.model.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import org.raflab.studsluzba.model.DrziPredmet;
import org.raflab.studsluzba.model.Ispit;
import org.raflab.studsluzba.model.PrijavaIspita;
import org.raflab.studsluzba.model.StudentIndeks;

public class IspitPrijavaDTO {
	
	
	private Long idIspit;
	private LocalDate datumOdrzavanja;
	private LocalTime vremeOdrzavanja;
	private String mestoOdrzavanja;
	private DrziPredmet drziPredmet;
	
	private boolean prijavljen;
	private Long idPrijave;
	
	

	public IspitPrijavaDTO() {		
	}



	public Long getIdIspit() {
		return idIspit;
	}



	public void setIdIspit(Long idIspit) {
		this.idIspit = idIspit;
	}



	public LocalDate getDatumOdrzavanja() {
		return datumOdrzavanja;
	}



	public void setDatumOdrzavanja(LocalDate datumOdrzavanja) {
		this.datumOdrzavanja = datumOdrzavanja;
	}



	public LocalTime getVremeOdrzavanja() {
		return vremeOdrzavanja;
	}



	public void setVremeOdrzavanja(LocalTime vremeOdrzavanja) {
		this.vremeOdrzavanja = vremeOdrzavanja;
	}



	public String getMestoOdrzavanja() {
		return mestoOdrzavanja;
	}



	public void setMestoOdrzavanja(String mestoOdrzavanja) {
		this.mestoOdrzavanja = mestoOdrzavanja;
	}



	public DrziPredmet getDrziPredmet() {
		return drziPredmet;
	}



	public void setDrziPredmet(DrziPredmet drziPredmet) {
		this.drziPredmet = drziPredmet;
	}



	public boolean isPrijavljen() {
		return prijavljen;
	}



	public void setPrijavljen(boolean prijavljen) {
		this.prijavljen = prijavljen;
	}



	public Long getIdPrijave() {
		return idPrijave;
	}



	public void setIdPrijave(Long idPrijave) {
		this.idPrijave = idPrijave;
	}

	

	
	
	
	

}
