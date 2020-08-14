package org.raflab.studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Predmet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String sifra;
	private String naziv;
	private String opis;
	private int ESPB;
	private int semestar;
	private int godinaStudija; // izracunava se na osnovu semestra
	@ManyToOne(fetch = FetchType.EAGER)
	private StudijskiProgram naProgramu;
	private int fondPredavanja;
	private int fondVezbe;
	
	
	
	
	
	// svaki predmet ima jedinstvenu sifru
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sifra == null) ? 0 : sifra.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Predmet other = (Predmet) obj;
		if (sifra == null) {
			if (other.sifra != null)
				return false;
		} else if (!sifra.equals(other.sifra))
			return false;
		return true;
	}
	
	
	
	
	
	
}
