package org.raflab.studsluzba.model.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Entitet koji se koristi za prenos podataka o studentu, 
 * mogu da budu samo osnovni podaci, bez indeksa, u slučaju
 * da je student unet u sistem ali mu još nije dodeljen indeks
 * ili podaci sa aktivnim indeksom. 
 * 
 * Koristi se kao rezultat pretrage studenata
 * 
 * @author bojanads
 *
 */

@Getter
@Setter

public class StudentDTO {
	
	private Long id;
	// dodati jos nesto?
	private String ime;
	private String prezime; 
	// indeks
	private int godinaUpisa;
	private String studProgram;
	private int broj;
	

}
