package org.raflab.studsluzba.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NastavnikDTO {

	private Long id;
	private String ime;	  // not null
	private String prezime;  // not null
	private String srednjeIme;   // not null 
	private String email;   // not null
	private String brojTelefona;
	private String adresa;	
	
}
