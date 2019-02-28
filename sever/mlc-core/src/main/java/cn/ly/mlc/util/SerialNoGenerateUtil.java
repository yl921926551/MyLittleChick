package cn.ly.mlc.util;

import java.util.Date;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import common.util.StringUtils;


public class SerialNoGenerateUtil {

	protected static Log logger = LogFactory.getLog(SerialNoGenerateUtil.class);
	
	
	public static String generateSerialNo(String businessType){
		String serialNo = null;
		if(StringUtils.isNullOrEmpty(businessType)) {//两位的业务代码
			return serialNo;
		}
		String date = StringUtils.dateTimeToString(new Date(), "yyyyMMdd");
		String time = StringUtils.dateTimeToString(new Date(), "HHmmss");
		serialNo = businessType + date + getTwo() + time + getTwo();
		return serialNo;
	}
	
	/**
	 * 产生随机的2位数
	 * @return
	 */
	public static String getTwo(){
		Random rad = new Random();
		String result  = rad.nextInt(100) +"";
		if(result.length()==1){
			result = "0" + result;
		}
		return result;
	}
	
}