package org.raflab.studsluzba.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Entity
@Data
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
}
