package org.raflab.studsluzba.model.dtos;

import org.raflab.studsluzba.model.StudentIndeks;

public class StudentIndeksPredispitneDTO {
	
	private StudentIndeks studentIndeks;
	private Float ukupnoPredispitne;
	private Long idPrijave;
	
	public StudentIndeks getStudentIndeks() {
		return studentIndeks;
	}
	public void setStudentIndeks(StudentIndeks studentIndeks) {
		this.studentIndeks = studentIndeks;
	}
	public Float getUkupnoPredispitne() {
		return ukupnoPredispitne;
	}
	public void setUkupnoPredispitne(Float ukupnoPredispitne) {
		this.ukupnoPredispitne = ukupnoPredispitne;
	}
	public Long getIdPrijave() {
		return idPrijave;
	}
	public void setIdPrijave(Long idPrijave) {
		this.idPrijave = idPrijave;
	}
	
	

}
