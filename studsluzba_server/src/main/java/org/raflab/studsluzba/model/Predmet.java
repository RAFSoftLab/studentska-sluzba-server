package org.raflab.studsluzba.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = {"studProgram"})
public class Predmet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String sifra;
	private String naziv;
	private String opis;
	private Integer espb;
	private Integer semestar;
	private Integer godinaStudija; // izracunava se na osnovu semestra
	@ManyToOne	
	private StudijskiProgram studProgram;
	private Integer fondPredavanja;
	private Integer fondVezbe;
	private String izbornaGrupa;
	private boolean obavezan;

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
