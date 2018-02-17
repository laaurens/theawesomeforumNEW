package com.fdmgroup.theawesomeforum.forum.profanity;

import java.util.List;

public class ProfanityFilterLogic {

	public static String filterProfanities(String stringToBeFiltered, List<Profanity> profanities) {
		for(Profanity profanity : profanities){
			stringToBeFiltered = stringToBeFiltered.replaceAll("(?i)"+profanity.getContent(), "*****");
		}
		return stringToBeFiltered;
	}

}
