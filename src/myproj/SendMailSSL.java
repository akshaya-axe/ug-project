/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myproj;

/**
 *
 * @author user
 */
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMailSSL {
	public static void main(String toEmail,String message) {
        try {
            //final  String fromEmail="cbmdinesh";
            
            
         //   String message="hai test mail";
              
          Properties props = new Properties();
  props.put("mail.smtp.host", "smtp.gmail.com");
  props.put("mail.smtp.auth", "true");
  props.put("mail.debug", "true");
  props.put("mail.smtp.port", "465");
  props.put("mail.smtp.socketFactory.port", "465");
  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.socketFactory.fallback", "false");

  Session session2 = Session.getDefaultInstance(props,new javax.mail.Authenticator() {

  protected PasswordAuthentication getPasswordAuthentication()
  {
  return new PasswordAuthentication("rajashree_94@yahoo.co.in","guruswamythatha");
  }
  });
   boolean debug = true;
  session2.setDebug(debug);
  Message msg = new MimeMessage(session2);
  InternetAddress addressFrom = new InternetAddress("rajashree_94@yahoo.co.in");
  msg.setFrom(addressFrom);
  InternetAddress[] addressTo = new InternetAddress[1];

  addressTo[0] = new InternetAddress(toEmail);

  msg.setRecipients(Message.RecipientType.TO, addressTo);

  // Setting the Subject and Content Type
  msg.setSubject("Asthma analysis");

  msg.setContent(message, "text/plain");
  Transport.send(msg);
        } catch (MessagingException ex) {
            Logger.getLogger(SendMailSSL.class.getName()).log(Level.SEVERE, null, ex);
        } 
	}
}