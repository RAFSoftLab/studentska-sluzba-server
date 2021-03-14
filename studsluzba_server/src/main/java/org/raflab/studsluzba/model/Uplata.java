package org.raflab.studsluzba.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Uplata {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@ManyToOne	
		private StudentIndeks studentIndeks;
	
		private String nacinUplate;
		private Float iznos;
		private Float kurs;
		
		private LocalDate datum;		
		
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
		public String getNacinUplate() {
			return nacinUplate;
		}
		public void setNacinUplate(String nacinUplate) {
			this.nacinUplate = nacinUplate;
		}
		public Float getIznos() {
			return iznos;
		}
		public void setIznos(Float iznos) {
			this.iznos = iznos;
		}
		public Float getKurs() {
			return kurs;
		}
		public void setKurs(Float kurs) {
			this.kurs = kurs;
		}
		public LocalDate getDatum() {
			return datum;
		}
		public void setDatum(LocalDate datum) {
			this.datum = datum;
		}
		
		
		
		
		
		
		

}
