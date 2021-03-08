package org.raflab.studsluzba.model;



import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class PrviUpis{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private Float uspehSrednjaSkola;
	private Float uspehPrijemni;
	@ManyToOne
	private SrednjaSkola zavrsenaSrednjaSkola;
	private String strucnaSprema;
	private Integer godinaZavrsetkaSrednjeSkole;
	private String prelazSaViskoskolskeUstanove;
	private LocalDate datumUpisa;
	private String napomena;
	private String prethodnoZavrseneStudije;
	private String visokoskolsaUstanovaZavrsenihStudija;
	private String stecenoZvanje;
	private Float prosecnaOcenaNaPrethodnimStudijama;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getUspehSrednjaSkola() {
		return uspehSrednjaSkola;
	}
	public void setUspehSrednjaSkola(Float uspehSrednjaSkola) {
		this.uspehSrednjaSkola = uspehSrednjaSkola;
	}
	public Float getUspehPrijemni() {
		return uspehPrijemni;
	}
	public void setUspehPrijemni(Float uspehPrijemni) {
		this.uspehPrijemni = uspehPrijemni;
	}
	public SrednjaSkola getZavrsenaSrednjaSkola() {
		return zavrsenaSrednjaSkola;
	}
	public void setZavrsenaSrednjaSkola(SrednjaSkola zavrsenaSrednjaSkola) {
		this.zavrsenaSrednjaSkola = zavrsenaSrednjaSkola;
	}
	public String getStrucnaSprema() {
		return strucnaSprema;
	}
	public void setStrucnaSprema(String strucnaSprema) {
		this.strucnaSprema = strucnaSprema;
	}
	public Integer getGodinaZavrsetkaSrednjeSkole() {
		return godinaZavrsetkaSrednjeSkole;
	}
	public void setGodinaZavrsetkaSrednjeSkole(Integer godinaZavrsetkaSrednjeSkole) {
		this.godinaZavrsetkaSrednjeSkole = godinaZavrsetkaSrednjeSkole;
	}
	public String getPrelazSaViskoskolskeUstanove() {
		return prelazSaViskoskolskeUstanove;
	}
	public void setPrelazSaViskoskolskeUstanove(String prelazSaViskoskolskeUstanove) {
		this.prelazSaViskoskolskeUstanove = prelazSaViskoskolskeUstanove;
	}
	public LocalDate getDatumUpisa() {
		return datumUpisa;
	}
	public void setDatumUpisa(LocalDate datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	public String getPrethodnoZavrseneStudije() {
		return prethodnoZavrseneStudije;
	}
	public void setPrethodnoZavrseneStudije(String prethodnoZavrseneStudije) {
		this.prethodnoZavrseneStudije = prethodnoZavrseneStudije;
	}
	public String getVisokoskolsaUstanovaZavrsenihStudija() {
		return visokoskolsaUstanovaZavrsenihStudija;
	}
	public void setVisokoskolsaUstanovaZavrsenihStudija(String visokoskolsaUstanovaZavrsenihStudija) {
		this.visokoskolsaUstanovaZavrsenihStudija = visokoskolsaUstanovaZavrsenihStudija;
	}
	public String getStecenoZvanje() {
		return stecenoZvanje;
	}
	public void setStecenoZvanje(String stecenoZvanje) {
		this.stecenoZvanje = stecenoZvanje;
	}
	public Float getProsecnaOcenaNaPrethodnimStudijama() {
		return prosecnaOcenaNaPrethodnimStudijama;
	}
	public void setProsecnaOcenaNaPrethodnimStudijama(Float prosecnaOcenaNaPrethodnimStudijama) {
		this.prosecnaOcenaNaPrethodnimStudijama = prosecnaOcenaNaPrethodnimStudijama;
	}
	
	
	
	
	
	
}
