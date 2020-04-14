package studsluzba.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrijavaIspita {
	private Date datumPrijave;
	private StudentIndeks student;
	private Ispit ispit;
	
	

}
