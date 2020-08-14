package studsluzba.model.coders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractCode {
	
	private String code;
	
	public abstract String getValue();

}
