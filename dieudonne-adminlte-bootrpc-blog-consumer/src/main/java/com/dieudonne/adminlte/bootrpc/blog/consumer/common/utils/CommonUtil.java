package com.dieudonne.adminlte.bootrpc.blog.consumer.common.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName:  CommonUtil   
 * @Description:通用工具类   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月28日 上午9:25:53   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class CommonUtil {
	
	private final static Pattern pat = Pattern.compile("-");
	/**
	 * UUID生成方法
	 * 
	 * @return
	 */
	public static String UUID() {
		UUID uid = UUID.randomUUID();
		return pat.matcher(uid.toString()).replaceAll("").toLowerCase();
	}
	/**
	 * 格式化异常
	 */
	public static String formatException(Exception e) {

		String message = e.getMessage();

		if (StringUtils.isBlank(message)) {

			return "Le système est occupé, je vous prie de réessayer plus tard.";
		}

		String runtimeStr = "java.lang.RuntimeException: ";
		message = message.replaceAll(runtimeStr, "");
		return message;
	}
	/**
	 * md5加密
	 * 
	 * @param s
	 * @return
	 */
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 文件重命名
	 * @param fileName
	 * @return
	 */
	public static String renameFile(String fileName) {
		// TODO Auto-generated method stub
		String now = formatDate(new Date(),"yyyyMMdd");
		String ext = fileName.substring(fileName.lastIndexOf("."));
		return now + File.separator+ RandomStringUtils.randomAlphanumeric(32) + ext;
	}
	/**
	 * 日期格式化
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 过滤非法字符
	 */
	public static String filterValidateChar(String str) {  
		
		if(StringUtils.isBlank(str)){
			return "";
		}
		str = str.toLowerCase().trim();//统一转为小写  
        
		String badStr = "'|exec|execute|insert|select|delete|update|drop|*|%|master|truncate|" +  
                "declare|sitename|net user|xp_cmdshell" ;
        String[] badStrs = badStr.split("\\|");  
        for (int i = 0; i < badStrs.length; i++) {  
            if (str.contains(badStrs[i])) {  
                str = str.replaceAll(badStrs[i], "");
            }  
        }  
        return str;  
    }
	/**
	 * 转换逻辑符号
	 * @param where
	 * @return
	 */
	public static String formatWhereSQL(String where) {
		// TODO Auto-generated method stub
		
		if(StringUtils.isBlank(where)){
			return "";
		}
		where = where.replaceAll("eq", " = ");
		where = where.replaceAll("nq", " != ");
		where = where.replaceAll("lt", " < ");
		where = where.replaceAll("lq", " <= ");
		where = where.replaceAll("gt", " > ");
		where = where.replaceAll("gq", " >= ");
		
		return where;
	} 
}
