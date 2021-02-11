package in.jobcounsel.services.utility;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppUtility {

	private static String regex = "^[a-zA-Z0-9 \"]+$";

	private static Logger logger = LoggerFactory.getLogger(AppUtility.class);

	private static final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

	public static Date convertStringDateToSQLDate(String date) {
		Date sqlDate = Date.valueOf(date);
		return sqlDate;
	}

	public static boolean isStringAlphaNumeric(String str) {
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(str);

		return matcher.matches();

	}

	public static String convertToIndianDateFormat(java.util.Date anyFormat) {
		String dateStr = "";
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateStr = format.format(anyFormat);
		} catch (Exception e) {
			logger.error("Error Occured While Converting SQL Date To Indian Format Input : {} Error Message : {}",
					anyFormat, e.getMessage());
		}
		return dateStr;
	}

	public static java.util.Date swapDateToIndianFormat(java.util.Date anyFormatDate) {
		SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
		String strDate = sm.format(anyFormatDate);
		java.util.Date dt = null;
		try {
			dt = sm.parse(strDate);
		} catch (ParseException e) {
			logger.error("Error Occured While Swapping Util Date To Indian Format Input : {} Error Message : {}",
					anyFormatDate, e.getMessage());
		}
		return dt;
	}

	public static String filterToAlphaNumericCharacters(String data) {
		String result = data.replaceAll("[^a-zA-Z0-9 \"]", "");
		return result;
	}

	public static Boolean isEmailValid(String emailId) {
		Boolean result = false;
		if (emailId != null) {
			Pattern emailPattern = Pattern.compile(emailRegex);
			Matcher matcher = emailPattern.matcher(emailId);
			result = matcher.matches();
		}
		return result;
	}

	public static String generateGUIDForEmail() {
		Long currentTime = System.currentTimeMillis();
		String guidGenerated = Long.toString(currentTime, 36);
		return guidGenerated;
	}
	
	public static String getCurrentDateInIndianFormatAsString() {
		return new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date());
	}

}
