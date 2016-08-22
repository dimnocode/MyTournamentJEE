package mt.validation;

import javax.servlet.http.HttpServletRequest;

public class Validation<T> {
	
	public boolean validate(HttpServletRequest request, T entity){
		switch(entity.getClass().getName()){
		
		case "mt.entities.User":
			return UserValidation.validate(request);
			
		case "mt.entities.Gameaccount":
			return GameAccountValidation.validate(request);
		
		case "mt.entities.Clan":
			return ClanValidation.validate(request);
			
		case "mt.entities.Game":
			return GameValidation.validate(request);
			
		case "mt.entities.Tournament":
			return TournamentValidation.validate(request);
			
		case "mt.entities.Platform":
			return PlatformValidation.validate(request);
			
		case "mt.entities.Typeoftournament":
			return TypeoftournamentValidation.validate(request);
			
		case "mt.entities.Formatoftournament":
			return FormatoftournamentValidation.validate(request);
		}
		return false;
	}
	
}
