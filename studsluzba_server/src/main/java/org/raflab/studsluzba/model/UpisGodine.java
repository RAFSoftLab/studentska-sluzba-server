package org.raflab.studsluzba.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
@Data
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

}
