package mt.validation;

import javax.servlet.http.HttpServletRequest;

import mt.entities.User;
import mt.validation.*;

public class Validation<T> {

	private HttpServletRequest request;
	private T entity;
	
	public Validation(HttpServletRequest request, T entity){
		this.request = request;
		this.entity = entity;
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
