package org.raflab.studsluzba.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Nastavnik {
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	 private String ime;	  // not null
	 private String prezime;  // not null
	 private String srednjeIme;   // not null 
	 private String email;   // not null
	 private String brojTelefona;
	 private String adresa;
	 @OneToMany(mappedBy = "nastavnik")
	 private Set<NastavnikZvanje> zvanja;
	

}
