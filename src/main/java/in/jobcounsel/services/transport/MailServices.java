package in.jobcounsel.services.transport;

import java.io.File;

public interface MailServices {
	
	public Boolean sendMail(String to, String from ,String mailSubject,String mailContent);
	
	public Boolean sendMailWithAttachment(String to,String from,String mailSubject,String mailContent,File file);

}
