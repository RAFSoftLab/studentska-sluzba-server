package studsluzba.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import studsluzba.model.coders.SimpleCodeValue;

@Getter
@Setter
public class NastavnikZvanje {
	private Date datumIzbora;  // ili reizbora
	private SimpleCodeValue uzaNaucnaOblast;
	private SimpleCodeValue zvanje;
	private boolean aktivno;
}
