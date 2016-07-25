package mt.validation;

import javax.servlet.http.HttpServletRequest;

import mt.entities.User;
import mt.validation.*;

public class Validation<T> {
	
	public boolean validate(HttpServletRequest request, T entity){
		switch(entity.getClass().getName()){
		
		case "mt.entities.User":
			return UserValidation.validate(request);
		}
		return false;
	}
	
}
