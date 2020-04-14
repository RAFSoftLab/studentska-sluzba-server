package studsluzba.model;


import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import studsluzba.model.coders.SimpleCodeValue;


@Getter
@Setter
public class StudentPodaci {
		
	 private String ime;	  // not null
	 private String prezime;  // not null
	 private String srednjeIme;   // not null 
	 private String jmbg;    
	 private Date datumRodjenja;  // not null
	 private SimpleCodeValue mestoRodjenja; 
	 private SimpleCodeValue mestoPrebivalista;  // not null
	 private SimpleCodeValue drzavaRodjenja;   
	 private SimpleCodeValue drzavljanstvo;   // not null
	 private String nacionalnost;   // samoizjasnjavanje, moze bilo sta  
	 private char pol;    // not null
	 private String adresa;  // not null
	 private String brojTelefona;  // not null
	 private String slika; // putanja do slike 
	 private String email;  // not null
	 private String brojLicneKarte; 
	 private String licnuKartuIzdao;
	 private SimpleCodeValue mestoStanovanja;
	 private String adresaStanovanja;
	 private List<AktivnostStudenta> aktivnosti;   // tok studija
	 
	  
	  
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
}
