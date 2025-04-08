package org.raflab.studsluzba.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


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
