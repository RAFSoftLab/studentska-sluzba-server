package org.raflab.studsluzba.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import studsluzba.model.coders.SimpleCode;

@Getter
@Setter

public class IspitniRok {
	private SimpleCode naziv;  // januarski, februarski
	private Date datumPocetka;
	private Date datumZavrsetka;
	private Date datumPocetkaPrijave;   // ako se prebacimo na prijavu svih ispita u odredjenom periodu
 	private Date datumZavrsetkaPrijave;
 	private SkolskaGodina skolskaGodina;
	
	
}
