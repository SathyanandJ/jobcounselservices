package in.jobcounsel.services.utility;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUtility {
	
	private static String regex = "^[a-zA-Z0-9 ]+$";
	
	public static Date convertStringDateToSQLDate(String date) {
		Date sqlDate=Date.valueOf(date);
		return sqlDate;
	}
	
	public static boolean isStringAlphaNumeric(String str) {
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(str);
		
		return matcher.matches();
		
	}

}
