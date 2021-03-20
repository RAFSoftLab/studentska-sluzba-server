package org.raflab.studsluzba.model.dtos;

import java.util.List;

import org.raflab.studsluzba.model.ObnovaGodine;
import org.raflab.studsluzba.model.OsvojeniPoeniPredispitne;
import org.raflab.studsluzba.model.PolozenPredmet;
import org.raflab.studsluzba.model.PredispitnaObaveza;
import org.raflab.studsluzba.model.PrijavaIspita;
import org.raflab.studsluzba.model.SlusaPredmet;
import org.raflab.studsluzba.model.StudentIndeks;
import org.raflab.studsluzba.model.UpisGodine;
import org.raflab.studsluzba.model.Uplata;

public class StudentWebProfileDTO {
	
	private StudentIndeks aktivanIndeks;	
	private List<PolozenPredmet> polozeniPredmeti;
	private List<UpisGodine> upisiGodine;
	private List<ObnovaGodine> obnoveGodine;	
	private List<Uplata> uplate;
	
	
	// za aktivnu skolsku godinu
	private List<OsvojeniPoeniPredispitne> osvojeniPoeniPredispitne;	
	private List<SlusaPredmet> slusaPredmete;
	
	
	public StudentIndeks getAktivanIndeks() {
		return aktivanIndeks;
	}
	public void setAktivanIndeks(StudentIndeks aktivanIndeks) {
		this.aktivanIndeks = aktivanIndeks;
	}
	public List<PolozenPredmet> getPolozeniPredmeti() {
		return polozeniPredmeti;
	}
	public void setPolozeniPredmeti(List<PolozenPredmet> polozeniPredmeti) {
		this.polozeniPredmeti = polozeniPredmeti;
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
	public List<OsvojeniPoeniPredispitne> getOsvojeniPoeniPredispitne() {
		return osvojeniPoeniPredispitne;
	}
	public void setOsvojeniPoeniPredispitne(List<OsvojeniPoeniPredispitne> osvojeniPoeniPredispitne) {
		this.osvojeniPoeniPredispitne = osvojeniPoeniPredispitne;
	}
	
	
	

}
