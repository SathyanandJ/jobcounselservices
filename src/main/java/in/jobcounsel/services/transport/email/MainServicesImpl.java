package in.jobcounsel.services.transport.email;

import java.io.File;

import org.springframework.stereotype.Service;

import in.jobcounsel.services.transport.MailServices;

@Service
public class MainServicesImpl implements MailServices{

	@Override
	public Boolean sendMail(String to, String from, String mailSubject, String mailContent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean sendMailWithAttachment(String to, String from, String mailSubject, String mailContent, File file) {
		// TODO Auto-generated method stub
		return null;
	}

}
