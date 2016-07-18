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
	
	public void validate(T entity){
		switch(entity.getClass().getName()){
		case "mt.entities.Tournament":
			System.out.println(entity.getClass().getName());
			break;
		}
	}
	
	
}
