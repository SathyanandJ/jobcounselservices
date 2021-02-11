package in.jobcounsel.services.core.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class EmailSubscriptionCore {

	@Getter
	@Setter
	private int id;
	@Getter
	@Setter
	private String email;
	@Getter
	@Setter
	private String emailguid;
	@Getter
	@Setter
	private char isEmailVerified;
	@Getter
	@Setter
	private char isSubscribed;

}
