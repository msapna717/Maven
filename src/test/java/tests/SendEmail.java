package tests;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

	public static void sendMail() throws EmailException {
		System.out.println("----test started---");
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("testSB2000@gmail.com", "Testing@79"));
		email.setSSLOnConnect(true);
		email.setFrom("testSB2000@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("ishan.sharma@gmail.com");
		email.send();
		System.out.println("----email sent---");

	}

}
