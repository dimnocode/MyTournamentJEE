package mt.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Util {
	
	public static Date stringToDate(String dateString){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = formatter.parse(dateString);
			System.out.println(formatter.format(date));
			
			return date;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	//METHODE QUI DEVRONT UTILISER LES REGEX, RETURN TRUE SI CA MATCH.
	public static boolean checkStringLength(String string){
		return true;
	}
	public static boolean checkPhoneNumber(String phoneNumber){
		return true;
	}
	public static boolean checkEmail(String email){
		return true;
	}
}
