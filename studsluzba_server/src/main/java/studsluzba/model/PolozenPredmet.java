package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PolozenPredmet {
	
	private int ocena;
	private IzlazakIspit ispit;  // 0..1, ako je priznat vrednost polja je null
	private Nastavnik nastavnik;
	private Predmet predmet;
	private boolean priznat;  // da li sacuvati sa koje visokoskolske ustanove?
	
	
}
