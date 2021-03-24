package org.raflab.studsluzba.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
