package org.raflab.studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class PolozenPredmet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer ocena;
	@ManyToOne
	@JoinColumn(nullable = true)	
	private IzlazakIspit ispit;  // 0..1, ako je priznat vrednost polja je null
	@ManyToOne	
	private Nastavnik nastavnik;
	@ManyToOne	
	@JoinColumn(name = "predmet_id")	
	private Predmet predmet;
	
	@ManyToOne	
	@JoinColumn(name = "student_indeks_id")	
	@JsonIgnore
	private StudentIndeks studentIndeks;
	
	
	private boolean priznat;  // da li sacuvati sa koje visokoskolske ustanove?
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getOcena() {
		return ocena;
	}
	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}
	public IzlazakIspit getIspit() {
		return ispit;
	}
	public void setIspit(IzlazakIspit ispit) {
		this.ispit = ispit;
	}
	public Nastavnik getNastavnik() {
		return nastavnik;
	}
	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public boolean isPriznat() {
		return priznat;
	}
	public void setPriznat(boolean priznat) {
		this.priznat = priznat;
	}
	
	
	
	
}
