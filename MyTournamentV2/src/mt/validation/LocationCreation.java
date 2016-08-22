package mt.validation;

import javax.servlet.http.HttpServletRequest;

import mt.entities.Location;

/**
 * @author Lucas Giunta
 *
 */
public final class LocationCreation {
	
	/**
	 * create object Location
	 * @param request http request
	 * @param location object Location
	 */
	public static void create(HttpServletRequest request, Location location){
		location.setStreet(request.getParameter("street"));
		location.setTown(request.getParameter("town"));
		location.setZipCode(request.getParameter("zipcode"));
		location.setCountry(request.getParameter("country"));
	}

}
