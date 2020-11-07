package in.jobcounsel.services.utility;

import java.sql.Date;

public class AppUtility {
	
	public static Date convertStringDateToSQLDate(String date) {
		Date sqlDate=Date.valueOf(date);
		return sqlDate;
	}

}
