package mt.validation;

import javax.servlet.http.HttpServletRequest;

import mt.entities.Location;

public final class LocationCreation {
	
	public static void create(HttpServletRequest request, Location location){
		location.setStreet(request.getParameter("street"));
		location.setTown(request.getParameter("town"));
		location.setZipCode(request.getParameter("zipcode"));
		location.setCountry(request.getParameter("country"));
	}

}
