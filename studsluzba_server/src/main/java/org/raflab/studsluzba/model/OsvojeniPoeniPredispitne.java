package org.raflab.studsluzba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class OsvojeniPoeniPredispitne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private StudentIndeks studentIndeks;
	private float poeni;
	@ManyToOne
	private PredispitnaObaveza predispitnaObaveza;
	
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
	public float getPoeni() {
		return poeni;
	}
	public void setPoeni(float poeni) {
		this.poeni = poeni;
	}
	public PredispitnaObaveza getPredispitnaObaveza() {
		return predispitnaObaveza;
	}
	public void setPredispitnaObaveza(PredispitnaObaveza predispitnaObaveza) {
		this.predispitnaObaveza = predispitnaObaveza;
	}
	
	
	
}
