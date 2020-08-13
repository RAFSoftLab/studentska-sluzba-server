package org.raflab.studsluzba.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ispit {
	
	private Date datumOdrzavanja;    // i vreme
	private String mestoOdrzavanja;  // ne mora da se unosi
	private boolean zakljucen;
	private Predmet predmet;
	private Nastavnik nastavnik;
	private IspitniRok ispitniRok;
	
	
}
