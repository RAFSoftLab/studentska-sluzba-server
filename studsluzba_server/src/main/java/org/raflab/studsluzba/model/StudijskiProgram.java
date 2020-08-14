package org.raflab.studsluzba.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudijskiProgram {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String oznaka;  // RN, RM   
	private String naziv;   
	private int godinaAkreditacije;
	private String zvanje;
	private int trajanjeGodina;
	private int trajanjeSemestara;
	private String vrstaStudija; // OAS - osnovne akademske studje, OSS - osnovne strukovne, 	MAS - master akademske studije,
	
	
	

}
