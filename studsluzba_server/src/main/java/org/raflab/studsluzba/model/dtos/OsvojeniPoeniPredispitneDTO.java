package org.raflab.studsluzba.model.dtos;

public class OsvojeniPoeniPredispitneDTO {
	
	private Long idStudentIndeks;
	private Long idPredispitnaObaveza;
	
	
	private float osvojeniPoeni;
	
	
	public OsvojeniPoeniPredispitneDTO() {
		
	}
	
	
	public OsvojeniPoeniPredispitneDTO(Long idStudentIndeks, Long idPredispitnaObaveza, float osvojeniPoeni) {		
		this.idStudentIndeks = idStudentIndeks;
		this.idPredispitnaObaveza = idPredispitnaObaveza;
		this.osvojeniPoeni = osvojeniPoeni;
	}
	
		
	
	
	public Long getIdStudentIndeks() {
		return idStudentIndeks;
	}
	public void setIdStudentIndeks(Long idStudentIndeks) {
		this.idStudentIndeks = idStudentIndeks;
	}
	public Long getIdPredispitnaObaveza() {
		return idPredispitnaObaveza;
	}
	public void setIdPredispitnaObaveza(Long idPredispitnaObaveza) {
		this.idPredispitnaObaveza = idPredispitnaObaveza;
	}
	public float getOsvojeniPoeni() {
		return osvojeniPoeni;
	}
	public void setOsvojeniPoeni(float osvojeniPoeni) {
		this.osvojeniPoeni = osvojeniPoeni;
	}
	
	
	

}
