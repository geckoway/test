package com.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaEncrypt extends Encrypt {

	/**
	 * SHA算法
	 * 
	 * @param str
	 * @return String
	 */
	public String encode(String str) {
		if (str == null || str == "")
			return null;
		StringBuffer hexString = new StringBuffer();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
			byte[] bytes = str.getBytes();
			md.update(bytes);
			byte[] reBytes = md.digest();
			for (int i = 0; i < reBytes.length; i++) {
				if ((0xff & reBytes[i]) < 0x10) {
					hexString.append("0" + Integer.toHexString((0xFF & reBytes[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & reBytes[i]));
				}
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e);
		}
		return hexString.toString().toUpperCase();
	}

	public static byte[] encryptMD5(byte[] data) throws Exception {

		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(data);
		return md5.digest();

	}
}
