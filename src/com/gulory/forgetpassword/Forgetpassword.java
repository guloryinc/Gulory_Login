package com.gulory.forgetpassword;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.apache.commons.mail.EmailException;

public class Forgetpassword {
	private static String email = null;
	private static boolean result = false;
	
	public Forgetpassword(String user_email){
		email = user_email;
	}

	public static boolean Send() throws SQLException, EmailException{
		
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	        }                             
		 
	        java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.1.6:3306/gulory_user_information", "root", "110110");

	        java.sql.Statement stmt = conn.createStatement();
	        
	        PreparedStatement ps = conn.prepareStatement("select email from user where email = ?");
	        ps.setString(1, email);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next()){
	        	result = true;
	        	String newpassword = getValidateNumber();
	        	
	        	String insertsql = "update user set password = ? where email = ?";
	            PreparedStatement ps2 = conn.prepareStatement(insertsql);
	            ps2.setString(1, newpassword);
	            ps2.setString(2, email);
	            int c = ps2.executeUpdate(); 
	            System.out.print(c);
	        	
	        	SendNewPasswordEmail sendnew = new SendNewPasswordEmail(email,newpassword);
	        	sendnew.SendEmail();
	        }
		return result;
	}
	
    public static String getValidateNumber() {
        Random random = new Random();
        int number = 0;
        for(int i = 0; i < 8 ; i++){
            int number2 = random.nextInt(10);
            number += number2;
            number = number*10;
        }

        
        
        return  Integer.toString(number);
    }
    
    
    
}
