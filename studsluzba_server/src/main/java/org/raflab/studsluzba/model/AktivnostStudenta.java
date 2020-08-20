package org.raflab.studsluzba.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AktivnostStudenta implements Comparable<AktivnostStudenta> {
	
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	*/
	
	private LocalDate datumIVreme;
	private String napomena;
	
	
	public int compareTo(AktivnostStudenta as) {
		return this.datumIVreme.compareTo(as.getDatumIVreme());
	}

}
