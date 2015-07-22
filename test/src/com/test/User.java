package com.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -474117028959258649L;

	private String username;

	private transient String password;

	public User(String username, String password) {
		this.username = username;

		this.password = password;
	}

	@Override
	public String toString() {
		return username + "" + password;
	}

	public static void main(String[] args) throws Exception {
		User user = new User("WeiDong", "123456");

		System.out.println("Before Serialization:" + user);

		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		// 创建一个对象输出流，通过对象输出流的writeObject()写对象到输出流中
		ObjectOutputStream out = new ObjectOutputStream(buf);

		out.writeObject(user);

		out.close();
		// 创建一个对象输入流，通过对象输入流的readObject()从输入流中读取对象
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));

		user = (User) in.readObject();

		System.out.println("After Serialization：" + user);

		in.close();
	}
}
