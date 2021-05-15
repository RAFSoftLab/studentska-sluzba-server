package org.raflab.studsluzba.model;

import java.time.LocalDate;
import java.util.List;
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
	private Integer prenosEspb; // podrazumevano 0
	private Integer godinaKojaSeUpisuje;
	@ManyToMany
	private List<Predmet> predmeti;
	@ManyToOne
	private SkolskaGodina skolskaGodina;
	
	private String napomena;
	
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
	public Integer getPrenosEspb() {
		return prenosEspb;
	}
	public void setPrenosEspb(Integer prenosEspb) {
		this.prenosEspb = prenosEspb;
	}
	public Integer getGodinaKojaSeUpisuje() {
		return godinaKojaSeUpisuje;
	}
	public void setGodinaKojaSeUpisuje(Integer godinaKojaSeUpisuje) {
		this.godinaKojaSeUpisuje = godinaKojaSeUpisuje;
	}
	public List<Predmet> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
