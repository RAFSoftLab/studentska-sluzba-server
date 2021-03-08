package org.raflab.studsluzba.model;



import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StudijskiProgram {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String oznaka;  // RN, RM   
	private String naziv;   
	private Integer godinaAkreditacije;
	private String zvanje;
	private Integer trajanjeGodina;
	private Integer trajanjeSemestara;
	private String vrstaStudija; // OAS - osnovne akademske studje, OSS - osnovne strukovne, 	MAS - master akademske studije
	
	@OneToMany(mappedBy = "studProgram")
	private List<Predmet> predmeti;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Integer getGodinaAkreditacije() {
		return godinaAkreditacije;
	}

	public void setGodinaAkreditacije(Integer godinaAkreditacije) {
		this.godinaAkreditacije = godinaAkreditacije;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public Integer getTrajanjeGodina() {
		return trajanjeGodina;
	}

	public void setTrajanjeGodina(Integer trajanjeGodina) {
		this.trajanjeGodina = trajanjeGodina;
	}

	public Integer getTrajanjeSemestara() {
		return trajanjeSemestara;
	}

	public void setTrajanjeSemestara(Integer trajanjeSemestara) {
		this.trajanjeSemestara = trajanjeSemestara;
	}

	public String getVrstaStudija() {
		return vrstaStudija;
	}

	public void setVrstaStudija(String vrstaStudija) {
		this.vrstaStudija = vrstaStudija;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	
	
	
	
}
