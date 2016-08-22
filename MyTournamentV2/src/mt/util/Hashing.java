package mt.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public final class Hashing {

	
	/**
	 * This method hash the password in @param 
	 * @param password
	 * @return 
	 */
	public static String hash(String password){
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			md.update(password.getBytes("UTF-8"));
			byte[] digest = md.digest();
			
			return String.format("%064x", new java.math.BigInteger(1, digest));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
