package mt.validation;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import mt.entities.Clan;
import mt.entities.User;
import mt.entities.Usersclan;
import mt.util.Util;

public class ClanCreation {
public static void create(HttpServletRequest request, Clan clan, Usersclan userClan){
		User user = Util.getLoggedUser(request);
		clan.setNom(request.getParameter("nameClan"));
		clan.setActive(true);
		clan.setCreationDate(new Date());
		
		userClan.setAddedDateTime(new Date());
		userClan.setClanLeader(true);
		userClan.setClan(clan);
		userClan.setUser(user);
	}
}
