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
public class PrviUpis{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private float uspehSrednjaSkola;
	private float uspehPrijemni;
	@ManyToOne(fetch = FetchType.EAGER)
	private SrednjaSkola zavrsenaSrednjaSkola;
	private String strucnaSprema;
	private int godinaZavrsetkaSrednjeSkole;
	private String prelazSaViskoskolskeUstanove;
	private LocalDate datumUpisa;
	private String napomena;
	private String prethodnoZavrseneStudije;
	private String visokoskolsaUstanovaZavrsenihStudija;
	private String stecenoZvanje;
	private float prosecnaOcenaNaPrethodnimStudijama;
	
	
	
}
