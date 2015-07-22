package com.test;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class T3 {

	static String[] az = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	// 加密
	public static String getBase64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}

	// 解密
	public static String getFromBase64(String s) {
		byte[] b = null;
		String result = null;
		if (s != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(s);
				result = new String(b, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// b(两位随机英文字母.b(三位随机英文字谜."pwd".四位随机英文字母))
		String pwd = "a123456";
		Random r = new Random();
		String s = getBase64((az[r.nextInt(az.length)] + az[r.nextInt(az.length)] + getBase64(az[r.nextInt(az.length)]
				+ az[r.nextInt(az.length)] + az[r.nextInt(az.length)] + pwd + az[r.nextInt(az.length)]
				+ az[r.nextInt(az.length)] + az[r.nextInt(az.length)] + az[r.nextInt(az.length)])));
		System.out.println(s);
	}
}
