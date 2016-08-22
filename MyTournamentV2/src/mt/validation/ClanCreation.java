package mt.validation;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import mt.entities.Clan;

/**
 * @author Lucas Giunta
 *
 */
public class ClanCreation {
/**
 * create object Clan
 * @param request http request
 * @param clan object Clan
 */
public static void create(HttpServletRequest request, Clan clan){
		clan.setName(request.getParameter("nameClan"));
		clan.setActive(true);
		clan.setCreationDate(new Date());
		
		
	}
}
