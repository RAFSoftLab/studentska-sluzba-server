package org.raflab.studsluzba.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Uplata extends AktivnostStudenta {
	
		private String nacinUplate;
		private float iznos;
		private float kurs;

}
