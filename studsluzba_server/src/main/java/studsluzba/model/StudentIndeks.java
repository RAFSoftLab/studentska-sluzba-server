package studsluzba.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import studsluzba.model.coders.SimpleCodeValue;

@Getter
@Setter
public class StudentIndeks {
	private int broj;
	private int godina;
	private StudijskiProgram studProgram;
	private SimpleCodeValue nacinFinansiranja;
	private String status; // aktivan
	private Date vaziOd;
	private StudentPodaci student;
	private List<PolozenPredmet> polozeniPredmeti;
	
	

}
