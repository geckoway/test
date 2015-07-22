package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {
		String a = "gsmS_msg a,b,c gsms_msg d,e,f";

		String b = "a,b,c d,e,f";
		System.out.println(a.replaceAll("(?i)gsms_msg", "gsms_msg2"));

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = df.parse("2015-03-14");
		Calendar cd = java.util.Calendar.getInstance();
		cd.setTime(d);
		cd.add(java.util.Calendar.DAY_OF_YEAR, 100);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cd.getTime()));

	}

}
