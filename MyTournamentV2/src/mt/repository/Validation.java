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
	
}
