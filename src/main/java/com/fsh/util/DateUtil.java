package com.fsh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @作者：Mr.冯
 * @日期：2019年9月11日
 */
public class DateUtil {

	public static int getAge (Calendar src){
		Calendar now = forCalendar(new Date());
		int j = now.get(Calendar.YEAR);
		
		int i = src.get(Calendar.YEAR);
		
		return j - i;
		
	}
	public static int getAge (String src){
		Calendar now = forCalendar(new Date());
		int j = now.get(Calendar.YEAR);
		
		Date forDate = forDate(src);
		Calendar forCalendar = forCalendar(forDate);
		int i = forCalendar.get(Calendar.YEAR);
		
		return j - i;
		
	}
	
	public static Calendar forCalendar(Date date){
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		return instance;
	}

	public static Date forDate(String str){
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = null;
		 try {
			 date = dateFormat.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static int getFutrueDays(String futrue){
		
		
		
		Date date = new Date();
		long time = date.getTime();
		
		Date forDate = forDate(futrue);
		long time2 = forDate.getTime();
		
		long dt = time2 - time;
		
		int day = (int) (dt/1000/60/60/24);
		
		
		return day;
	}
	public static int getpassDays(String futrue){
		
		Date date = new Date();
		long time = date.getTime();
		
		Date forDate = forDate(futrue);
		long time2 = forDate.getTime();
		
		long dt = time - time2;
		
		int day = (int) (dt/1000/60/60/24);
		
		
		return day;
	}
	
	/*
	 * 判断给定日期是否是当天
	 */
	public static boolean isToday(String  str){
		/*
		 * 获取日期的年月日
		 * Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		instance.get(Calendar.YEAR);
		instance.get(Calendar.MONTH);
		instance.get(Calendar.DAY_OF_MONTH);*/
		
		int futrueDays = getFutrueDays(str);
		if(futrueDays == 0){
			return true ;
		}
		
		return false;
	}
	/**
	 * 判断当前给定日期是否在本周之内
	 */
	public static boolean isdayinweek(String date){
		Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		int YEAR = instance.get(Calendar.YEAR);
		int MONTH = instance.get(Calendar.MONTH);
		int dayofweek = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		Date forDate = forDate(date);
		Calendar forCalendar = forCalendar(forDate);
		int year = forCalendar.get(Calendar.YEAR);
		int month = forCalendar.get(Calendar.MONTH);
		int dayofweek1 = forCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		if(YEAR == year && MONTH == month && dayofweek==dayofweek1){
			return true ;
		}
		return false;
	}
	/*
	 * 获取该日期的月初日期
	 */
	public static void intofirstDatemonth(Calendar target){
		target.set(Calendar.DATE,1);
		target.set(Calendar.HOUR,0);
		target.set(Calendar.MINUTE,0);
		target.set(Calendar.SECOND,0);
		
	}
	
	public static Date setLastDateofMonth(int year, int month) throws ParseException{
		  //选中月份的最后一天
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
 
        //格式化日期，不需要时分秒的话可以去掉
        String endDateStr = year + "-" + month + "-" + lastDay + " 23:59:59";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
        Date endDate = df.parse(endDateStr);
 
        return endDate;

	}

}
