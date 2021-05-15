package org.raflab.studsluzba.model;

import java.io.Serializable;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class StudentIndeks {	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int broj;
	private int godina;
	private String studProgramOznaka;
	private String nacinFinansiranja;
	private boolean aktivan; 
	private LocalDate vaziOd;
	@ManyToOne
	private StudentPodaci student;
	
	@ManyToOne
	private StudijskiProgram studijskiProgram;   // na koji studijski program je upisan
	
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
	}
	public int getGodina() {
		return godina;
	}
	public void setGodina(int godina) {
		this.godina = godina;
	}
	
	public String getStudProgramOznaka() {
		return studProgramOznaka;
	}
	public void setStudProgramOznaka(String studProgramOznaka) {
		this.studProgramOznaka = studProgramOznaka;
	}
	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}
	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}
	public boolean isAktivan() {
		return aktivan;
	}
	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	public LocalDate getVaziOd() {
		return vaziOd;
	}
	public void setVaziOd(LocalDate vaziOd) {
		this.vaziOd = vaziOd;
	}
	public StudentPodaci getStudent() {
		return student;
	}
	public void setStudent(StudentPodaci student) {
		this.student = student;
	}
	public String getNacinFinansiranja() {
		return nacinFinansiranja;
	}
	public void setNacinFinansiranja(String nacinFinansiranja) {
		this.nacinFinansiranja = nacinFinansiranja;
	}
	
	
	
	
	

}
