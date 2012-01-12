package com.gulory.forgetpassword;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendNewPasswordEmail {
	
	private static String useremail = null;
	private static String newuserpasswords = null;
		
	public SendNewPasswordEmail(String useremailaddress , String newuserpassword){
		useremail = useremailaddress;
		newuserpasswords = newuserpassword;
		
	}
	
	
    public static void SendEmail() throws EmailException    
    {    
        SimpleEmail email = new SimpleEmail();       
//        email.setTLS(true); //Set TLS
        email.setSSL(true);   //Set SSL
        email.setHostName("smtp.gmail.com");          
        email.setAuthentication("hello@gulory.com", "@gulorycom");   //User name and password
        email.setFrom("hello@gulory.com", "New password for DataBumble.");
            
        try     
        {    
          email.addTo(useremail); //Receiver    
 //           email.addCc("xxx@gulory.com"); //CC     
//            email.addBcc("xxx@gulory.com"); //CC secret 
            email.setSubject("New password for DataBumble.");         //Title       
            email.setMsg( "Please click the link below to signin DataBumble with your new password! " +"\n" + "Your information: \n" + "	Your user name:  " + useremail +"\n	Your new password:   " + newuserpasswords + "\n\nPlease contact hello@gulory.com for any questions about technical support or sales.\n"
            + "\nThanks,\n" + "DataBumble Team\n" + "www.databumble.com" );   

            email.send();     
                
        } catch (EmailException e) {    
            e.printStackTrace();    
        }     
    }    

}
