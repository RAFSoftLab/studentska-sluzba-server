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
public class NastavnikZvanje {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private LocalDate datumIzbora;  // ili reizbora
	private String naucnaOblast;  // sifarnik na klijentu - tabela u bazi bez veze
	private String uzaNaucnaOblast;  // sifarnik na klijentu - tabela u bazi bez veze
	private String zvanje;   // sifarnik na klijentu - tabela u bazi bez veze
	private boolean aktivno;
	@ManyToOne(fetch = FetchType.EAGER)
	private Nastavnik nastavnik;
}
