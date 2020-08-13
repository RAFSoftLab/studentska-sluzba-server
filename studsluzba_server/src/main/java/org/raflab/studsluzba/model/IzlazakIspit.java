package org.raflab.studsluzba.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IzlazakIspit {
	private PrijavaIspita prijava;
	private float brojPoenaIspit;
	private float brojPoenaPredispitne;  // automatski se sabira, ne unosi se
	private boolean ponisten;
	private String napomena;
	
}
