package in.co.init.OLM.admin;
import java.io.UnsupportedEncodingException;  
import java.util.Properties;  
import java.util.logging.Level;  
import java.util.logging.Logger;  
import javax.mail.Authenticator;  
import javax.mail.Message;  
import javax.mail.MessagingException;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
  
public class SendEmail {  
  
    private String SMTP_HOST = "smtp.gmail.com";  
    private String FROM_ADDRESS = "swaas.acrostic.gtbit@gmail.com";  
    private String PASSWORD = "timepass_08081990";  
    private String FROM_NAME = "Prabhjot";  
  
    public boolean sendMail(String s3, String subject, String message) {  
        try {  
            Properties props = new Properties();  
            props.put("mail.smtp.host", SMTP_HOST);  
            props.put("mail.smtp.auth", "true");  
            props.put("mail.debug", "false");  
            props.put("mail.smtp.ssl.enable", "true");  
  
            Session session = Session.getInstance(props, new SocialAuth());  
            Message msg = new MimeMessage(session);  
  
            InternetAddress from = new InternetAddress(FROM_ADDRESS, FROM_NAME); 
            msg.setFrom(from);  
  
//            InternetAddress[] toAddresses = new InternetAddress[recipients.length];  
//            for (int i = 0; i < recipients.length; i++) {  
//                toAddresses[i] = new InternetAddress(recipients[i]);  
//            }  
//            msg.setRecipients(Message.RecipientType.TO, toAddresses);  
            
  InternetAddress to=new InternetAddress(s3);
  msg.setRecipient(Message.RecipientType.TO, to);
  
  
       
            msg.setSubject(subject);  
            msg.setContent(message, "text/html");  
            Transport.send(msg);  
            return true;  
        } catch (UnsupportedEncodingException ex) {  
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);  
            return false;  
  
        } catch (MessagingException ex) {  
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);  
            return false;  
        }  
    }  
  
    class SocialAuth extends Authenticator {  
  
        @Override  
        protected PasswordAuthentication getPasswordAuthentication() {  
  
            return new PasswordAuthentication(FROM_ADDRESS, PASSWORD);  
  
        }  
    }  
    public static void main(String[] args) {  
//    	  String[] recipients = new String[]{"kaurprabhjot90@yahoo.co.in"};  
//    	  String r="kaurprabhjot90@yahoo.co.in";
//        String[] bccRecipients = new String[]{"swaas.acrostic.gtbit@gmail.com"};  
//        String subject = "Hi this is test Mail";  
//        String messageBody = "Test Mail from init";  
//  
//        new SendEmail().sendMail(r,subject, messageBody);  
  
    }  
}  
