package org.raflab.studsluzba.model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class PrijavaIspita {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate datumPrijave;
	@ManyToOne	
	private StudentIndeks studentIndeks;
	@ManyToOne
	private Ispit ispit;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDatumPrijave() {
		return datumPrijave;
	}
	public void setDatumPrijave(LocalDate datumPrijave) {
		this.datumPrijave = datumPrijave;
	}
	
	public Ispit getIspit() {
		return ispit;
	}
	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}
	public StudentIndeks getStudentIndeks() {
		return studentIndeks;
	}
	public void setStudentIndeks(StudentIndeks studentIndeks) {
		this.studentIndeks = studentIndeks;
	}
	
	
	
	
	
	

}
