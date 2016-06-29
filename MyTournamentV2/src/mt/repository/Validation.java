package mt.repository;

import javax.servlet.http.HttpServlet;

public class Validation<T> {

	private HttpServlet http;
	private T entity;
	
	public Validation(HttpServlet http, T entity){
		this.http = http;
		this.entity = entity;
	}
	
	public boolean validate(){
		if(this.entity == null){
			return false;
		}
		else{
			return true;
		}
	}
}
