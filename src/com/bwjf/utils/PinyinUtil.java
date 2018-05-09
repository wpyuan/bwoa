package com.bwjf.utils;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
/**
 * @author 张恭雨
 * 创建时间：2017年10月30日 下午12:40:30
 * 类描述：将汉字转化为拼音工具
 * 版本：v1.0 
 */
public class PinyinUtil {
	
	public static String getPinyin(String chinese){
		String pinyinStr="";
		char[] newChar=chinese.toCharArray();
		HanyuPinyinOutputFormat defaultFormat=new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		
		for (int i = 0; i < newChar.length; i++) {
			if(newChar[i]>128){
				try {
					pinyinStr+=PinyinHelper.toHanyuPinyinStringArray
							(newChar[i], defaultFormat)[0];
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}else{
				pinyinStr+=newChar[i];
			}
		}
		return pinyinStr;
	}
}
