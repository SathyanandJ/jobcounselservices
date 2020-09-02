package in.jobcounsel.platform.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobServicesException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(JobServicesException.class);

	public JobServicesException(String errorMessage, String errorCode) {
		super(errorMessage);
		logger.debug("ErrorMessage: {}, ErrorCode : {}", errorMessage, errorCode);
	}
}
