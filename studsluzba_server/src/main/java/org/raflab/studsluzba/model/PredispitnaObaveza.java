package org.raflab.studsluzba.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PredispitnaObaveza {
	private String naziv;
	private float maxBrojPoena;
	private SkolskaGodina skolskaGodina;
	private Predmet predmet;  // na kom predmetu vazi, 
							  // u predmetu ne treba cuvati listu Pred. obaveza 
							  // jer svaka skoslka godina ima svoju 
}
