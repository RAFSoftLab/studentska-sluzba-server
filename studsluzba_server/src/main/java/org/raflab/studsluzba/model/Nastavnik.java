package org.raflab.studsluzba.model;

import java.time.LocalDate;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Nastavnik {
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 private String ime;	  // not null
	 private String prezime;  // not null
	 private String srednjeIme;   // not null 
	 private String email;   // not null
	 private String brojTelefona;
	 private String adresa;	 
	 @OneToMany(mappedBy = "nastavnik")
	 private Set<NastavnikZvanje> zvanja;
	 
	 private LocalDate datumRodjenja;
	 private Character pol;
	 private String jmbg;
	 
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getSrednjeIme() {
		return srednjeIme;
	}
	public void setSrednjeIme(String srednjeIme) {
		this.srednjeIme = srednjeIme;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public Set<NastavnikZvanje> getZvanja() {
		return zvanja;
	}
	public void setZvanja(Set<NastavnikZvanje> zvanja) {
		this.zvanja = zvanja;
	}
	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public Character getPol() {
		return pol;
	}
	public void setPol(Character pol) {
		this.pol = pol;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	 
	
	 
	 
	

}
