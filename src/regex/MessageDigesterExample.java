package regex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigesterExample {

	public static void main(String[] args) {

		String s = "Hello!.. This is message digester example";

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] result = md.digest(s.getBytes());
			StringBuffer sb = new StringBuffer();
			for (byte b : result) {
				sb.append(String.format("%02x", b & 0xff));
			}
			System.out.println(sb.toString());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
