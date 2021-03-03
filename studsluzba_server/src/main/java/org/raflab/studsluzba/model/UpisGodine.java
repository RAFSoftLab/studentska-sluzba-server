package org.raflab.studsluzba.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class UpisGodine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private StudentIndeks studentIndeks;
	private LocalDate datumUpisa;
	private int prenosEspb; // podrazumevano 0
	private int godinaKojaSeUpisuje;
	@ManyToMany
	private Set<Predmet> predmeti;
	
	public StudentIndeks getStudentIndeks() {
		return studentIndeks;
	}
	public void setStudentIndeks(StudentIndeks studentIndeks) {
		this.studentIndeks = studentIndeks;
	}
	public LocalDate getDatumUpisa() {
		return datumUpisa;
	}
	public void setDatumUpisa(LocalDate datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	public int getPrenosEspb() {
		return prenosEspb;
	}
	public void setPrenosEspb(int prenosEspb) {
		this.prenosEspb = prenosEspb;
	}
	public int getGodinaKojaSeUpisuje() {
		return godinaKojaSeUpisuje;
	}
	public void setGodinaKojaSeUpisuje(int godinaKojaSeUpisuje) {
		this.godinaKojaSeUpisuje = godinaKojaSeUpisuje;
	}
	public Set<Predmet> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(Set<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	
	

}
