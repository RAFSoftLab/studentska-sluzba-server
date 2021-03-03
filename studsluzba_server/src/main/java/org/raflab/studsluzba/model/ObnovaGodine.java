package org.raflab.studsluzba.model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObnovaGodina extends AktivnostStudenta {
	private int godinaKojuObnavlja;	
	private Set<Predmet> upisujePredmete;	
}
