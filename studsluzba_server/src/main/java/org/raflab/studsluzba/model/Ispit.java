package org.raflab.studsluzba.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ispit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private LocalDate datumOdrzavanja;    // i vreme
	private String mestoOdrzavanja;  // ne mora da se unosi
	private boolean zakljucen;
	@ManyToOne(fetch = FetchType.EAGER)
	private Predmet predmet;
	@ManyToOne(fetch = FetchType.EAGER)
	private Nastavnik nastavnik;
	@ManyToOne(fetch = FetchType.EAGER)
	private IspitniRok ispitniRok;
	
	
}
