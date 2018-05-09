package com.bwjf.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;




/**
 * @author 张恭雨
 * 创建时间：2017年10月27日 下午3:34:43
 * 类描述：日期转换工具
 * 版本：v1.0 
 */
public class DateUtil {
	
	public static Date getDate(String s){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {		
			return format.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block			
			return null;
		}
		
	}
	// 2017/11/21
	public static Date getDateTime(String s){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {		
			return format.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block			
			return null;
		}
		
	}
	
	public static String getTomorrow(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar.getTime(); //这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		return dateString;
	}
}
