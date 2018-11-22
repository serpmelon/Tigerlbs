package com.neuqsoft.mysqlshell.common;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class MD5 {

	public static String md5(String source) {
		StringBuilder result = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytes = md.digest(source.getBytes());
			String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c",
					"d", "e", "f" };
			for (byte b : bytes) {
				int n = b;
				if (n < 0)
					n = 256 + n;
				result.append(String.valueOf(hexDigits[n / 16] + hexDigits[n % 16]));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result.toString();
	}
}
