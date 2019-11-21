package com.fsh.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	

	/*(1)	将\n\r替换成一个\n。（2分）
	(2)	将\n结尾的这行文本用<p></p>标签包起来。（6分）
	(3)	将单个\r字符使用<br/>标签替换。（2分）
	(4)	方法不报错，返回正确结果。（4分）
	(5)	该方法必须是在自己的工具包工程中，且在StringUtil工具中。（2*/

	public static String replaceStr(String str) {
		StringBuffer buffer = new StringBuffer();
		String[] split = str.split("(\r\n)");
		for (String string : split) {
			buffer.append("<P>");
			String replaceAll = string.replaceAll("(\r)", "<br>");
			buffer.append(replaceAll);
			buffer.append("</P>   ");
		}
		return buffer.toString();
	}
	
	
	public static boolean isBlank(String str) {
		//trim()
		if(str!=null&&str.length()>0&&str.trim().length()>0) {
			return true;
		}
		return false;
	}
//	(3)	测试StringUtil工具类中的是否为邮箱isEmail()工具方法
//	。传一个非法的邮箱测试不通过（4分）。传一次合法的邮箱，测试通过（4分）。
	public static boolean isPhone(String str) {
		boolean blank = isBlank(str);
		if(!blank) {
			return false;
		}
		Pattern pattern = Pattern.compile("^1[3|4|5|7|8][0-9]\\d{8}$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
	public static boolean isEmail(String str) {
		boolean blank = isBlank(str);
		if(!blank) {
			return false;
		}
		Pattern pattern = Pattern.
				compile("^([a-z0-9A-Z]+)@([a-z0-9A-Z]+\\.)+[a-zA-Z]{2,}$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
}
