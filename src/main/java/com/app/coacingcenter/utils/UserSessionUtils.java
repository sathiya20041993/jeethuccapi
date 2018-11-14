package com.app.coacingcenter.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class UserSessionUtils {

	public static Map<String, List<String>> userSession = new HashMap<>();

	public static String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public static boolean validateUserSession(String userId, String sessionId) {

		boolean validSession = false;

		if (UserSessionUtils.userSession.containsKey(userId)) {
			List<String> sessionIds = UserSessionUtils.userSession.get(userId);
			validSession = sessionIds.contains(sessionId);
		}
		return validSession;
	}
}
