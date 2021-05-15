package org.raflab.studsluzba.model.dtos;

public class RezultatIspitaDTO {
	
	
	private Long idPrijave;
	private Float ukupnoPredispitne;
	private Float poeniIspit;
	private int ocena;
	private boolean ponisten;
	private String napomena;
	
	
	public Float getUkupnoPredispitne() {
		return ukupnoPredispitne;
	}
	public void setUkupnoPredispitne(Float ukupnoPredispitne) {
		this.ukupnoPredispitne = ukupnoPredispitne;
	}
	public Float getPoeniIspit() {
		return poeniIspit;
	}
	public void setPoeniIspit(Float poeniIspit) {
		this.poeniIspit = poeniIspit;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
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
	public Long getIdPrijave() {
		return idPrijave;
	}
	public void setIdPrijave(Long idPrijave) {
		this.idPrijave = idPrijave;
	}

}
