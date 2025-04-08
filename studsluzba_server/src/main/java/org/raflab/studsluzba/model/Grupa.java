package org.raflab.studsluzba.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Grupa {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private SkolskaGodina skolskaGodina;
	
	
	private int semestar; // redni broj semestra 1,2,3,4,5...
	
	@ManyToOne
	private StudijskiProgram studijskiProgram;
	
	@ManyToMany
	private List<Predmet> predmeti;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public int getSemestar() {
		return semestar;
	}

	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}

	

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	
	
	
	

}
