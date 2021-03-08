package org.raflab.studsluzba.model.dtos;

import java.util.List;

import org.raflab.studsluzba.model.ObnovaGodine;
import org.raflab.studsluzba.model.PolozenPredmet;
import org.raflab.studsluzba.model.Predmet;
import org.raflab.studsluzba.model.PrijavaIspita;
import org.raflab.studsluzba.model.SlusaPredmet;
import org.raflab.studsluzba.model.StudentIndeks;
import org.raflab.studsluzba.model.UpisGodine;
import org.raflab.studsluzba.model.Uplata;

/*
 * objekat ove kalse sadrzi sve podatke o studentu koji
 * se prikazuju u njegovom profilu  
 * 
 * - polozeni predmeti
 * - tok studija (upisi, obnove godina)
 * - predmete koje slusa
 * - prijavljeni ispiti
 * - uplate
 * 
 * - selektujemo preko indeksa, potrebno prikupiti podatke i o drugim indeksima
 * 
 */

public class StudentProfileDTO {
	
	private StudentIndeks aktivanIndeks;  
	private List<StudentIndeks> neaktivniIndeksi;
	private List<PolozenPredmet> polozeniPredmeti;
	private List<UpisGodine> upisiGodine;
	private List<ObnovaGodine> obnoveGodine;	
	private List<Uplata> uplate;
	
	// za aktivnu skolsku godinu
	
	private List<PrijavaIspita> prijaveIspita;	
	private List<SlusaPredmet> slusaPredmete;
	
	
	public StudentIndeks getAktivanIndeks() {
		return aktivanIndeks;
	}
	public void setAktivanIndeks(StudentIndeks studentIndeks) {
		this.aktivanIndeks = studentIndeks;
	}
	public List<PolozenPredmet> getPolozeniPredmeti() {
		return polozeniPredmeti;
	}
	public void setPolozeniPredmeti(List<PolozenPredmet> polozeniPredmeti) {
		this.polozeniPredmeti = polozeniPredmeti;
	}	
	public List<Uplata> getUplate() {
		return uplate;
	}
	public void setUplate(List<Uplata> uplate) {
		this.uplate = uplate;
	}
	public List<SlusaPredmet> getSlusaPredmete() {
		return slusaPredmete;
	}
	public void setSlusaPredmete(List<SlusaPredmet> slusaPredmete) {
		this.slusaPredmete = slusaPredmete;
	}
	
	public List<UpisGodine> getUpisiGodine() {
		return upisiGodine;
	}
	public void setUpisiGodine(List<UpisGodine> upisiGodine) {
		this.upisiGodine = upisiGodine;
	}
	public List<ObnovaGodine> getObnoveGodine() {
		return obnoveGodine;
	}
	public void setObnoveGodine(List<ObnovaGodine> obnoveGodine) {
		this.obnoveGodine = obnoveGodine;
	}
	public List<StudentIndeks> getNeaktivniIndeksi() {
		return neaktivniIndeksi;
	}
	public void setNeaktivniIndeksi(List<StudentIndeks> neaktivniIndeksi) {
		this.neaktivniIndeksi = neaktivniIndeksi;
	}
	public List<PrijavaIspita> getPrijaveIspita() {
		return prijaveIspita;
	}
	public void setPrijaveIspita(List<PrijavaIspita> prijaveIspita) {
		this.prijaveIspita = prijaveIspita;
	}
	
	
	
	
	
	
	

}
