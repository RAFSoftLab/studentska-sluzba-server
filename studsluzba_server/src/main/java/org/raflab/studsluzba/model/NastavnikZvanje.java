package org.raflab.studsluzba.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
public class NastavnikZvanje {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate datumIzbora;  // ili reizbora
	private String naucnaOblast;  // sifarnik na klijentu - tabela u bazi bez veze
	private String uzaNaucnaOblast;  // sifarnik na klijentu - tabela u bazi bez veze
	private String zvanje;   // sifarnik na klijentu - tabela u bazi bez veze
	private boolean aktivno;
	@ManyToOne
	private Nastavnik nastavnik;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDatumIzbora() {
		return datumIzbora;
	}
	public void setDatumIzbora(LocalDate datumIzbora) {
		this.datumIzbora = datumIzbora;
	}
	public String getNaucnaOblast() {
		return naucnaOblast;
	}
	public void setNaucnaOblast(String naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}
	public String getUzaNaucnaOblast() {
		return uzaNaucnaOblast;
	}
	public void setUzaNaucnaOblast(String uzaNaucnaOblast) {
		this.uzaNaucnaOblast = uzaNaucnaOblast;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	public boolean isAktivno() {
		return aktivno;
	}
	public void setAktivno(boolean aktivno) {
		this.aktivno = aktivno;
	}
	public Nastavnik getNastavnik() {
		return nastavnik;
	}
	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}
	
	
}
