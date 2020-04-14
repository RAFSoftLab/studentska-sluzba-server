package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OsvojeniPoeniPredispitne {
	private StudentIndeks student;
	private float poeni;
	private PredispitnaObaveza predispitnaObaveza;
	
}
