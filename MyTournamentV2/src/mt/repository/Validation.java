package mt.repository;

import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
public class Validation<T> {

	private HttpServletRequest http;
	private T entity;
	
	public Validation(HttpServletRequest http, T entity){
		this.http = http;
		this.entity = entity;
	}
	
	public boolean validate(){
		if(this.entity == null || this.http == null){
			return false;
		}
		else{
			return true;
		}
	}
	public Date stringToDate(String dateString){
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
	public String getDateNow(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	//METHODE QUI DEVRONT UTILISER LES REGEX, RETURN TRUE SI CA MATCH.
	public boolean checkStringLength(String string){
		return true;
	}
	public boolean checkPhoneNumber(String phoneNumber){
		return true;
	}
	public boolean checkEmail(String email){
		return true;
	}
}
