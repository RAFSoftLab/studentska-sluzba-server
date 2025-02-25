package org.raflab.studsluzba.model;

import lombok.Data;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class SkolskaGodina {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int pocetna;
	private int krajnja;
	private boolean aktivna;
	
	private LocalDate datumPocetka;

//	public void setPocetna(int pocetna) {
//		this.pocetna = pocetna;
//		this.krajnja = pocetna+1;
//	}
//
}
