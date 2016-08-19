package mt.validation;

import javax.servlet.http.HttpServletRequest;

import mt.entities.Platform;

public final class PlatformCreation {
	
	public static void create(HttpServletRequest request, Platform Platform){
		Platform.setActive(true);
		Platform.setName(request.getParameter("namePlatforms"));
	}
}
