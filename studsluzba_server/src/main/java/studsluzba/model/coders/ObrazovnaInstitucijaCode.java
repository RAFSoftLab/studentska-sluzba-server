package studsluzba.model.coders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

// srednja skola ili viskoskolska ustanova
public class ObrazovnaInstitucijaCode extends AbstractCode {
	
	private String naziv;
	private SimpleCodeValue mesto;
	private String adresa;
	private TipObrazovneInstitucije tip;

	@Override
	public String getValue() {		
		return this.naziv+", "+mesto.getValue();
	}
	
	

}
