package by.bsuir.Kaminsky.server.ImplemenationLayer;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	/**
	 * Compute hash for specified string
	 * @param str - String for which the hash is calculated
	 * @return hash value
	 */
	public static String getHash(String str) {
	    MessageDigest messageDigest = null;
	    byte[] digest = new byte[0];
	    BigInteger bigInt;
	    String md5Hex;
	    
	    try {
	        messageDigest = MessageDigest.getInstance("MD5");
	        messageDigest.reset();
	        messageDigest.update(str.getBytes("UTF8"));
	        digest = messageDigest.digest();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }catch (UnsupportedEncodingException e) {
	    	e.printStackTrace();
		}	    
	    bigInt = new BigInteger(1, digest);
	    md5Hex = bigInt.toString(16);
	    while( md5Hex.length() < 32 ){
	        md5Hex = "0" + md5Hex;
	    }
	    return md5Hex;
	}	
}
