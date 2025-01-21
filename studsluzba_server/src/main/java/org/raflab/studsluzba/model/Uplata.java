package org.raflab.studsluzba.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
