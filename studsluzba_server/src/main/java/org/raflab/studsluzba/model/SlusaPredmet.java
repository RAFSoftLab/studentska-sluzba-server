package org.raflab.studsluzba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SlusaPredmet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne	
	private StudentIndeks studentIndeks;
	
	@ManyToOne
	private DrziPredmet drziPredmet;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public StudentIndeks getStudentIndeks() {
		return studentIndeks;
	}
	public void setStudentIndeks(StudentIndeks studentIndeks) {
		this.studentIndeks = studentIndeks;
	}
	public DrziPredmet getDrziPredmet() {
		return drziPredmet;
	}
	public void setDrziPredmet(DrziPredmet drziPredmet) {
		this.drziPredmet = drziPredmet;
	}
	
	
	

}
