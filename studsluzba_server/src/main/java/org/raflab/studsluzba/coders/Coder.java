package studsluzba.model.coders;

import java.util.List;

import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
public abstract class Coder<T extends AbstractCode>{
	
	List<T> codes;
	
	public String getValueForCode(String code) {
		for(T coderItem : codes) {
			if(coderItem.getCode().equals(code))
				return coderItem.getValue();
		}
		return null;
	}
	

}
