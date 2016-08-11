package mt.validation;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import mt.entities.Tournament;
import mt.util.Util;


public final class TournamentCreation {
	
	public static void create(HttpServletRequest request, Tournament tournament){
		tournament.setName(request.getParameter("nameTournament"));
		tournament.setGame(null); //NMDQUERY OR CONTEXT ?
		tournament.setTypeoftournament(null); //NMDQUERY OR CONTEXT ?
		tournament.setFormatoftournament(null);  //NMDQUERY OR CONTEXT ?
		tournament.setStartDate(Util.stringToDate(request.getParameter("startDateTournament")));
		tournament.setEndDate(Util.stringToDate(request.getParameter("endDateTournament")));
		tournament.setCreationDate(new Date());
		tournament.setModificationDate(new Date());
		
		if(request.getParameter("onlineTournament") != null) {
			
			tournament.setOnline(true);
			tournament.set
		}
		
	}

}
