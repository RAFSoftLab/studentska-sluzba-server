package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SlusaPredmet {
	private StudentIndeks student;
	private Predmet predmet;
	private Nastavnik nastavnik;
	private SkolskaGodina skolskaGodina;

}
