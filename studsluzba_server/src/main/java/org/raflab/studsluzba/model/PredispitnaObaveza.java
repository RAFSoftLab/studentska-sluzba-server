package org.raflab.studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;


@Entity
public class PredispitnaObaveza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String naziv;
	private float maxBrojPoena;
	@ManyToOne
	private SkolskaGodina skolskaGodina;
	@ManyToOne
	private Predmet predmet;  // na kom predmetu vazi, u predmetu ne treba cuvati listu Pred. obaveza jer svaka skoslka godina ima svoju
	@ManyToOne
	private Nastavnik nastavnik; // ako vise nastavnika drzi isti predmet svako moze da zada svoje predispitne obaveze
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public float getMaxBrojPoena() {
		return maxBrojPoena;
	}
	public void setMaxBrojPoena(float maxBrojPoena) {
		this.maxBrojPoena = maxBrojPoena;
	}
	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}
	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
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
	
	
}
