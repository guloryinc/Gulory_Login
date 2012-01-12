package com.gulroy.login.example;

import java.sql.SQLException;

import org.apache.commons.mail.EmailException;

import com.gulory.forgetpassword.Forgetpassword;

public class ForgetpasswordExample {
	
	public static void main(String[] args) throws SQLException, EmailException{
		Forgetpassword test = new Forgetpassword("hello@gulory.com");
		System.out.print(test.Send());
	}

}
