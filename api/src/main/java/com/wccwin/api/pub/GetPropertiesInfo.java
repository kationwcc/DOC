package com.wccwin.api.pub;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * 专门用于取得公共properties参数的类
 * @author Administrator
 * wmq 20130730
 */
public class GetPropertiesInfo {
	private static Properties pro = null;
	private static InputStream in = null;
	
	static{
		try {
			pro = new Properties();
			in = GetPropertiesInfo.class.getResourceAsStream("/publicArgs.properties");
			pro.load(in);
		} catch (IOException e) {
			System.out.println("未找到加载文件 ...");
		}finally{
			try {
				if (in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 根据key得到properties中的值
	 * @param key
	 * @return
	 */
	public static String getPropertiesInfo(String key){
		String value = "";
		try {
			value = ios_UTF(pro.getProperty(key));
		} catch (UnsupportedEncodingException e) {
			System.out.println("转换出错...");
		}
		return value;
	}
	
	public static String ios_UTF(String str) throws UnsupportedEncodingException{
		String iso_UTF = "";
		if(str != null && !"".equals(str)){
			iso_UTF = new String(str.getBytes("ISO8859-1"),"UTF-8");
		}
		return iso_UTF;
	}
}
