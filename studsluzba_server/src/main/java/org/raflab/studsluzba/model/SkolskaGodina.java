package org.raflab.studsluzba.model;

import lombok.Data;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


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
