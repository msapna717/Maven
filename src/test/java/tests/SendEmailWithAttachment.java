package tests;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmailWithAttachment {
	public static void sendMail() throws EmailException {
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("/Users/sapnamishra/Desktop/testFiles/butterfly.jpeg");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Picture of butterfly");
		attachment.setName("butterfly");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("testSB2000@gmail.com", "Testing@79"));
		email.setSSLOnConnect(true);
		email.setHostName("smtp.googlemail.com");
		email.addTo("ishan.sharma@sourcebits.com", "sapna mishra");
		email.setFrom("testSB2000@gmail.com", "Me");
		email.setSubject("The picture");
		email.setMsg("Here is the picture you wanted");

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();
	}
}
