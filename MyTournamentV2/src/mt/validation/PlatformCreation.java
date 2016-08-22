package mt.validation;

import javax.servlet.http.HttpServletRequest;

import mt.entities.Platform;

/**
 * @author Lucas Giunta
 *
 */
public final class PlatformCreation {
	
	/**
	 * create object Platform
	 * @param request http request
	 * @param Platform object Platform
	 */
	public static void create(HttpServletRequest request, Platform Platform){
		Platform.setActive(true);
		Platform.setName(request.getParameter("namePlatforms"));
	}
}
