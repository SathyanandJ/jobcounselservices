package in.jobcounsel.services.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ControllerResponseGenerationHelper {
	
	public static HttpHeaders getDefaultJsonHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		return headers;
	}
	
	public static ResponseEntity getDefaultTimeoutRunnableResponseHeader() {
		return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).header(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8")
	      .body("Request timeout occurred.");
	}
}
