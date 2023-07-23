package co.edureka.boot.utils;

import java.util.Base64;

public class PasswordEncoder {

	public PasswordEncoder() {
		System.out.println("PasswordEncoder :: Constructor");
	}
	
	public String encodePassword(String pwd) {
		Base64.Encoder encoder = Base64.getEncoder();
		String encodedPwd = encoder.encodeToString(pwd.getBytes());
		return encodedPwd;
	}
}
