package org.raflab.studsluzba.model;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class StudentPodaci{ 
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	 private String ime;	  // not null
	 private String prezime;  // not null
	 private String srednjeIme;   // not null 
	 private String jmbg;    
	 private LocalDate datumRodjenja;  // not null
	 private String mestoRodjenjaCode; 
	 private String mestoPrebivalistaCode;  // not null
	 private String drzavaRodjenjaCode;   
	 private String drzavljanstvoCode;   // not null
	 private String nacionalnost;   // samoizjasnjavanje, moze bilo sta  
	 private char pol;    // not null
	 private String adresa;  // not null
	 private String brojTelefona;  // not null
	 private String slika; // putanja do slike 
	 private String email;  // not null
	 private String brojLicneKarte; 
	 private String licnuKartuIzdao;
	 private String mestoStanovanjaCode;
	 private String adresaStanovanja;
	 /*
	 @OneToMany(mappedBy = "student")
	 @JsonBackReference
	 private List<StudentIndeks> indeksi;
	 */
		 	 
	
	
	
}
