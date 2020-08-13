package org.raflab.studsluzba.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AktivnostStudenta implements Comparable<AktivnostStudenta> {
	
	private Date datumIVreme;
	private String napomena;
	
	
	public int compareTo(AktivnostStudenta as) {
		return this.datumIVreme.compareTo(as.getDatumIVreme());
	}

}
