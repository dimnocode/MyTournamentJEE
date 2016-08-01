package mt.validation;

import javax.servlet.http.HttpServletRequest;

public class Validation<T> {
	
	public boolean validate(HttpServletRequest request, T entity){
		switch(entity.getClass().getName()){
		
		case "mt.entities.User":
			return UserValidation.validate(request);
			
		case "mt.entities.Gameaccount":
			return GameAccountValidation.validate(request);
		}
		return false;
	}
	
}
