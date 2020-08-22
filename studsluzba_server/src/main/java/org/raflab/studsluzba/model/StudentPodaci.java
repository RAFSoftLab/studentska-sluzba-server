package org.raflab.studsluzba.model;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class StudentPodaci{ 
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
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
	 private String adresaStanovanja;   // u toku studija
	 @OneToOne(fetch = FetchType.EAGER)
	 private PrviUpis prviUpis;
	 
//	 opstina stanovanja i prebivalista
	 
	 
	 /*
	 @OneToMany(mappedBy = "student")
	 @JsonBackReference
	 private List<StudentIndeks> indeksi;
	 */
		 	 
	
	
	
}
