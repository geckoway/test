package com.test;

public class Test2 {

	public static void main(String[] args) {
		String password = "123456";
		Encrypt encrypt = new ShaEncrypt();
		password = encrypt.encode(password);
		System.out.println(password);
	}
}
