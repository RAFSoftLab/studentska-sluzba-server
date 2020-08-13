package org.raflab.studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class StudentIndeks {	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int broj;
	private int godina;
	private String studProgram;
	//private SimpleCodeValue nacinFinansiranja;
	private boolean aktivan; // aktivan
	private LocalDate vaziOd;
	@ManyToOne(fetch = FetchType.EAGER)
	private StudentPodaci student;
	//private List<PolozenPredmet> polozeniPredmeti;
	
	

}
