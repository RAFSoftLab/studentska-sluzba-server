package studsluzba.model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import studsluzba.model.coders.SimpleCodeValue;

@Getter
@Setter
public class StudijskiProgram {
	
	private String oznaka;  // RN, RM   
	private String naziv;   
	private int godinaAkreditacije;
	private String zvanje;
	private int trajanjeGodina;
	private int trajanjeSemestara;
	private SimpleCodeValue vrstaStudija; // OAS - osnovne akademske studje, OSS - osnovne strukovne, 	MAS - master akademske studije,
	private Set<Predmet> predmeti;
	
	

}
