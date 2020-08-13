package org.raflab.studsluzba.model;

import lombok.Getter;
import lombok.Setter;
import studsluzba.model.coders.ObrazovnaInstitucijaCode;
import studsluzba.model.coders.SimpleCodeValue;




@Getter
@Setter
public class PrviUpis extends AktivnostStudenta {
	
	private float uspehSrednjaSkola;
	private float uspehPrijemni;
	private ObrazovnaInstitucijaCode zavrsenaSrednjaSkola;
	private SimpleCodeValue strucnaSprema;
	private int godinaZavrsetkaSrednjeSkole;
	private ObrazovnaInstitucijaCode prelazSaViskoskolskeUstanove;
	
	
	
}
