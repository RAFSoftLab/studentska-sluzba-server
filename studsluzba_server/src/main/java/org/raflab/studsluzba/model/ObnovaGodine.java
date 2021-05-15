package org.raflab.studsluzba.model;

import java.time.LocalDate;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class ObnovaGodine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private StudentIndeks studentIndeks;
	
	private Integer godinaKojuObnavlja;	
	
	@ManyToMany
	private List<Predmet> upisujePredmete;
	
	private LocalDate datumObnove;	
	
	private String napomena;
	
	@ManyToOne
	private SkolskaGodina skolskaGodina;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getGodinaKojuObnavlja() {
		return godinaKojuObnavlja;
	}
	public void setGodinaKojuObnavlja(int godinaKojuObnavlja) {
		this.godinaKojuObnavlja = godinaKojuObnavlja;
	}
	public List<Predmet> getUpisujePredmete() {
		return upisujePredmete;
	}
	public void setUpisujePredmete(List<Predmet> upisujePredmete) {
		this.upisujePredmete = upisujePredmete;
	}
	public StudentIndeks getStudentIndeks() {
		return studentIndeks;
	}
	public void setStudentIndeks(StudentIndeks studentIndeks) {
		this.studentIndeks = studentIndeks;
	}
	public LocalDate getDatumObnove() {
		return datumObnove;
	}
	public void setDatumObnove(LocalDate datumObnove) {
		this.datumObnove = datumObnove;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}
	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}	
	
	
	
	
	
}
