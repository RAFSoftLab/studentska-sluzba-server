package org.raflab.studsluzba.model;

import lombok.Data;

import java.time.LocalDate;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
@Data
public class IspitniRok {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String naziv;  // januarski, februarski
	private LocalDate datumPocetka;
	private LocalDate datumZavrsetka;
	private LocalDate datumPocetkaPrijave;   // ako se prebacimo na prijavu svih ispita u odredjenom periodu
 	private LocalDate datumZavrsetkaPrijave;
 	@ManyToOne
 	private SkolskaGodina skolskaGodina;
}
