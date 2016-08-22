package mt.validation;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import mt.entities.Clan;

public class ClanCreation {
public static void create(HttpServletRequest request, Clan clan){
		clan.setName(request.getParameter("nameClan"));
		clan.setActive(true);
		clan.setCreationDate(new Date());
		
		
	}
}
