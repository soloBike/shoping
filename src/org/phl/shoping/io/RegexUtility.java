package org.phl.shoping.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtility {

	public void RefgexUtility() {
	}

	public static boolean isInteger(String str) {
		return isPositiveInteger(str) || isZero(str);

	}

	private static boolean isMatch(String regex, String orginal) {
		if (orginal == null || orginal.trim().equals("")) {
			return false;

		} else {
			Pattern pattern = Pattern.compile(regex);
			Matcher isNum = pattern.matcher(orginal);
			return isNum.matches();
		}
	}

	private static boolean isPositiveInteger(String orginal) {
		return isMatch("^\\d", orginal);
	}

	public static boolean isFloat(String orginal) {
		return isMatch("^\\d*.\\d", orginal);
	}

	public static boolean isZero(String orginal) {
		return isMatch("[+-]{0,1}0", orginal);
	}

	public static boolean isNumber(String orginal) {
		return isZero(orginal) || isPositiveInteger(orginal) || isFloat(orginal);
	}
}
