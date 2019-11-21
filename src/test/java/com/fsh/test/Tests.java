package com.fsh.test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.fsh.Utils.DateUtils;
import com.fsh.Utils.FileTest;
import com.fsh.util.DateUtil;

/**
 * @作者：Mr.冯
 * @日期：2019年9月11日
 */
public class Tests {

	@Test
	public void testDate(){
		
		int da = DateUtil.getAge("1999-10-08");
		System.out.println(da);
	}
	
	@Test
	public void testfutrue(){
		
		int da = DateUtil.getFutrueDays("2019-09-30");
		System.out.println(da);
	}
	@Test
	public void testpass(){
		
		int da = DateUtil.getpassDays("2019-09-01");
		System.out.println(da);
	}
	@Test
	public void testistoday(){
		
		boolean da = DateUtil.isToday("2019-09-11");
		System.out.println(da);
	}
	@Test
	public void testisweek(){
		
		Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		int YEAR = instance.get(Calendar.YEAR);
		int MONTH = instance.get(Calendar.MONTH);
		int dayofweek = instance.get(Calendar.DAY_OF_WEEK);
		System.out.println(YEAR);
		System.out.println(MONTH);
		System.out.println(dayofweek);
		
		boolean isdayinweek = DateUtil.isdayinweek("2019-05-18 11:37:22");
		System.out.println(isdayinweek);
		
	}
	
	
	 //* 获取该日期的月初日期
	 
	@Test
	public void intoFirstDateofmonthtest(){
		GregorianCalendar calendar = new GregorianCalendar(2019,9,19);
		
		DateUtil.intofirstDatemonth(calendar);
		System.out.println(calendar.getTime());
	}
	
	 //* 获取该日期的月末日期
	 
	@Test
	public void setLastDateofMonth() throws ParseException{
		
		Date setLastDateofMonth = DateUtil.setLastDateofMonth(2019, 9);
		System.out.println(setLastDateofMonth);
	}
	
	
	
	
	@Test
	public void setInitDate() {
		DateUtils.setInitDate("2019-05-18 11:37:22");
	}
	@Test
	public void getSuffixName() {
		String suffixName = FileTest.getSuffixName("d://jjj.png");
		
		System.out.println(suffixName);
	}
	
}
