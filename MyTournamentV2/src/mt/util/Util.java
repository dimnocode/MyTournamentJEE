package mt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mt.entities.User;

public final class Util {
	
	public static Date stringToDate(String dateString){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = formatter.parse(dateString);			
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date stringToDateTime(String dateString){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
		try {
			Date date = formatter.parse(dateString);			
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static User getLoggedUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("loggedUser");
		
		return user;
	}	
}
