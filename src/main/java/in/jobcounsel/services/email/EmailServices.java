package in.jobcounsel.services.email;

import java.util.List;

import in.jobcounsel.services.core.models.EmailSubscriptionCore;

public interface EmailServices {

	public Boolean sendEmailConfirmationLink(String emailId,String emailGuid);
	
	public Boolean sendJobNotificationToSubscribers(List<EmailSubscriptionCore> emailIds,String fileName);
	
}
