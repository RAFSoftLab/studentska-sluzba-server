package org.raflab.studsluzba.model;

import java.time.LocalDate;
import java.util.Date;

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
public class IspitniRok {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String naziv;  // januarski, februarski
	private LocalDate datumPocetka;
	private LocalDate datumZavrsetka;
	private LocalDate datumPocetkaPrijave;   // ako se prebacimo na prijavu svih ispita u odredjenom periodu
 	private LocalDate datumZavrsetkaPrijave;
 	@ManyToOne(fetch = FetchType.EAGER)
 	private SkolskaGodina skolskaGodina;
	
	
}
