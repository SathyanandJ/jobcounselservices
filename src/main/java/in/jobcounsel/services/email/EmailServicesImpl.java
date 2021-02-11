package in.jobcounsel.services.email;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import in.jobcounsel.services.core.models.EmailSubscriptionCore;
import in.jobcounsel.services.utility.AppUtility;

@Service
public class EmailServicesImpl implements EmailServices {

	Logger logger = LoggerFactory.getLogger(EmailServicesImpl.class);

	@Override
	public Boolean sendEmailConfirmationLink(String emailId, String emailGuid) {
		Boolean result = sendConfirmationMail(emailId, emailGuid);
		return result;
	}

	@Override
	public Boolean sendJobNotificationToSubscribers(List<EmailSubscriptionCore> validSubList, String fileName) {
		Boolean mailSendStatus = true;
		String mail_from = getEmailFrom();
		String host = getHost();

		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("admin@jobcounsel.in", "Chair0306!");

			}
		});

		try {

			for (EmailSubscriptionCore sub : validSubList) {

				Message message = new MimeMessage(session);

				MimeBodyPart messageBodyPart1 = new MimeBodyPart();
				MimeBodyPart messageBodyPart2 = new MimeBodyPart();  

				try {
					message.setFrom(new InternetAddress(mail_from, "JOBCounsel India Notifications"));
				} catch (UnsupportedEncodingException e) {
					logger.error("Error Message :{}", e.getLocalizedMessage());
				}

				message.addRecipient(Message.RecipientType.TO, new InternetAddress(sub.getEmail()));

				message.setSubject("JobCounsel India Government Jobs On "+ AppUtility.getCurrentDateInIndianFormatAsString());

				String bodyText = "Hello, <br> <br> Please find attached in the PDF the list of Job Openings as on "+ AppUtility.getCurrentDateInIndianFormatAsString() + " . <br><br><br> In case you want to unsubscribe for mail notifications please click the below link <br><br> http://localhost:9090/services/v1/user/email/unsubscribe?emailId="
						+ sub.getEmail()+"&id="+sub.getEmailguid() + " <br><br> Regards <br> JobCounsel Team";
				messageBodyPart1.setText(bodyText, "UTF-8", "html");
				
				DataSource source = new FileDataSource(fileName); 
				messageBodyPart2.setDataHandler(new DataHandler(source));  
				messageBodyPart2.setFileName("Jobs_"+AppUtility.getCurrentDateInIndianFormatAsString()+".pdf");

				Multipart multipart = new MimeMultipart();

				multipart.addBodyPart(messageBodyPart1);
				multipart.addBodyPart(messageBodyPart2);

				logger.debug("Sending Mail To {} For Email Confirmation");

				message.setContent(multipart);

				Transport.send(message);
			}

			logger.debug("Sent message successfully....");

		} catch (MessagingException mex) {
			logger.error("Error Occured While Sending Mail Notifications Error Message:{}", mex.getLocalizedMessage());
			mailSendStatus = false;
		}
		return mailSendStatus;

	}

	private Boolean sendConfirmationMail(String emailId, String emailGUID) {
		Boolean mailSendStatus = true;
		String mail_to = emailId;
		String mail_from = getEmailFrom();
		String host = getHost();

		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("admin@jobcounsel.in", "Chair0306!");

			}
		});

		try {

			Message message = new MimeMessage(session);

			MimeBodyPart mbp = new MimeBodyPart();

			try {
				message.setFrom(new InternetAddress(mail_from, "JOBCounsel India Notifications"));
			} catch (UnsupportedEncodingException e) {
				logger.error("Error Message :{}", e.getLocalizedMessage());
			}

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail_to));

			message.setSubject("Mail Confirmation Request");

			String bodyText = "Hello Thanks for Subscribing to Job Counsel India. Please click the below link for confirming your mail id.<br> <br> <br> http://localhost:9090/services/v1/user/email/confirmation/"
					+ emailGUID + " <br><br> Regards <br> JobCounsel Team";
			mbp.setText(bodyText, "UTF-8", "html");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(mbp);

			logger.debug("Sending Mail To {} For Email Confirmation");

			message.setContent(multipart);

			Transport.send(message);

			logger.debug("Sent message successfully....");

		} catch (MessagingException mex) {
			logger.error("Error Occured While Sending Confirmation Mail To {}", mail_to);
			logger.error("Error Message :{}", mex.getLocalizedMessage());
			mailSendStatus = false;
		}
		return mailSendStatus;
	}

	private String getEmailFrom() {
		return "admin@jobcounsel.in";
	}

	private String getHost() {
		return "smtp.gmail.com";
	}

}
