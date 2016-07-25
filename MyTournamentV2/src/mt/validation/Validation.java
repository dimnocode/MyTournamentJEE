package mt.validation;

import javax.servlet.http.HttpServletRequest;

import mt.entities.User;
import mt.validation.*;

public class Validation<T> {

	public Validation(HttpServletRequest request, T entity){
		
		this.checkType(request, entity);

	}
	
	private void checkType(HttpServletRequest request, T entity){
		switch(entity.getClass().getName()){
		
		case "mt.entities.User":
			if(UserValidation.validate(request)){
				UserCreation.create(request, (User)entity);
			}
			break;
		
		}
	}
	
}
