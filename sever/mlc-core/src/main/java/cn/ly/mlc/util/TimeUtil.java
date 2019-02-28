package cn.ly.mlc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import common.util.StringUtils;
/**
 */
public class TimeUtil {

	/**
	 * 获取 当前年、半年、季度、月、日、小时 开始结束时间
	 */

	

	/**
	 * 获得本周的第一天，周一
	 * 
	 * @return
	 */
	public static Date getCurrentWeekDayStartTime() {
		Calendar c = Calendar.getInstance();
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			int weekday = c.get(Calendar.DAY_OF_WEEK) - 2;
			c.add(Calendar.DATE, -weekday);
			c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c.getTime();
	}

	/**
	 * 获得本周的最后一天，周日
	 * 
	 * @return
	 */
	public static Date getCurrentWeekDayEndTime() {
		Calendar c = Calendar.getInstance();
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int weekday = c.get(Calendar.DAY_OF_WEEK);
			c.add(Calendar.DATE, 8 - weekday);
			c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c.getTime();
	}
	
	/**
	 * 获得本天的开始时间
	 * 
	 * @return
	 */
	public static Date getCurrentDayStartTime() {
		Date now = new Date();
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			StringUtils.dateTimeToString(now, "yyyyMMddHHmmss");
			now = shortSdf.parse(shortSdf.format(now));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得本天的结束时间
	 * 
	 * @return
	 */
	public static Date getCurrentDayEndTime() {
		Date now = new Date();
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			now = longSdf.parse(shortSdf.format(now) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得本小时的开始时间
	 * 
	 * @return
	 */
	public static Date getCurrentHourStartTime() {
		Date now = new Date();
		try {
			SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");;
			now = longHourSdf.parse(longHourSdf.format(now));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得本小时的结束时间
	 * 
	 * @return
	 */
	public static Date getCurrentHourEndTime() {
		Date now = new Date();
		try {
			SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");;
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			now = longSdf.parse(longHourSdf.format(now) + ":59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得月的开始时间(不传,默认本月)
	 * 
	 * @return
	 */
	public static Date getMonthStartTime(Date date) {
		Calendar c = Calendar.getInstance();
		if(date != null){
			c.setTime(date);
		}
		Date now = null;
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			c.set(Calendar.DATE, 1);
			now = shortSdf.parse(shortSdf.format(c.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	/**
	 * 月的结束时间(不传,本月)
	 * 
	 * @return
	 */
	public static Date getMonthEndTime(Date date) {
		Calendar c = Calendar.getInstance();
		if(date != null){
			c.setTime(date);
		}
		Date now = null;
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			c.set(Calendar.DATE, 1);
			c.add(Calendar.MONTH, 1);
			c.add(Calendar.DATE, -1);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
	/**
	 * 获得上月的开始时间
	 * 
	 * @return
	 */
	public static Date getLastMonthStartTime() {
		Calendar c = Calendar.getInstance();
		Date now = null;
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			c.set(Calendar.DATE, 1);
			c.add(Calendar.MONTH, -1);
			now = shortSdf.parse(shortSdf.format(c.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前年的开始时间
	 * 
	 * @return
	 */
	public static Date getCurrentYearStartTime() {
		Calendar c = Calendar.getInstance();
		Date now = null;
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			c.set(Calendar.MONTH, 0);
			c.set(Calendar.DATE, 1);
			now = shortSdf.parse(shortSdf.format(c.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前年的结束时间
	 * 
	 * @return
	 */
	public static Date getCurrentYearEndTime() {
		Calendar c = Calendar.getInstance();
		Date now = null;
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			c.set(Calendar.MONTH, 11);
			c.set(Calendar.DATE, 31);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前季度的开始时间
	 * 
	 * @return
	 */
	public static Date getCurrentQuarterStartTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (currentMonth >= 1 && currentMonth <= 3)
				c.set(Calendar.MONTH, 0);
			else if (currentMonth >= 4 && currentMonth <= 6)
				c.set(Calendar.MONTH, 3);
			else if (currentMonth >= 7 && currentMonth <= 9)
				c.set(Calendar.MONTH, 4);
			else if (currentMonth >= 10 && currentMonth <= 12)
				c.set(Calendar.MONTH, 9);
			c.set(Calendar.DATE, 1);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前季度的结束时间
	 * 
	 * @return
	 */
	public static Date getCurrentQuarterEndTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (currentMonth >= 1 && currentMonth <= 3) {
				c.set(Calendar.MONTH, 2);
				c.set(Calendar.DATE, 31);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 5);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				c.set(Calendar.MONTH, 8);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 11);
				c.set(Calendar.DATE, 31);
			}
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获取前/后半年的开始时间
	 * 
	 * @return
	 */
	public static Date getHalfYearStartTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (currentMonth >= 1 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 0);
			} else if (currentMonth >= 7 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 6);
			}
			c.set(Calendar.DATE, 1);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;

	}

	/**
	 * 获取前/后半年的结束时间
	 * 
	 * @return
	 */
	public static Date getHalfYearEndTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (currentMonth >= 1 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 5);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 11);
				c.set(Calendar.DATE, 31);
			}
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获取当前时间是在本周的第几天
	 * （0-6） 0代表周日
	 */
	public static int getDayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if(week_index<0){
			week_index = 0;
		} 
		return week_index;
	}

	/**
	 * 获取当前时间是在本月的第几天
	 */
	public static int getDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day_index = cal.get(Calendar.DAY_OF_MONTH);
		return day_index;
	}

	/**
	 * 获取日期--不包含时分秒
	 * 
	 * @throws ParseException
	 */
	public static Date getDate(Date date) {
		String dateString = StringUtils.dateTimeToString(date, "yyyy-MM-dd");
		try {
			date = StringUtils.stringToDate(dateString, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获得本周的最后一天，周日--不包含时分秒
	 * 
	 * @return
	 */
	public static Date getCurrentWeekDayEndDate() {
		Calendar c = Calendar.getInstance();
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			int weekday = c.get(Calendar.DAY_OF_WEEK);
			c.add(Calendar.DATE, 8 - weekday);
			c.setTime(shortSdf.parse(shortSdf.format(c.getTime())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c.getTime();
	}

	/**
	 * 获得本周的最后一天，周日--不包含时分秒
	 * 
	 * @return
	 */
	public static Date getCurrentMonthDayEndDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		try {
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			c.setTime(shortSdf.parse(shortSdf.format(c.getTime())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return c.getTime();
	}

	/**
	 * 时间字符串返回天数
	 * 
	 * @return
	 */
	public static int getCurrentDay(String dateString) {
		if (StringUtils.isNullOrEmpty(dateString)) {
			Calendar c = Calendar.getInstance();
			try {
				SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = shortSdf.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			int day = c.get(Calendar.DAY_OF_MONTH);
			return day;
		}
		return 0;
	}
	
	/**
	 * 两个时间相差天数
	 * @param smdate
	 * @param bdate
	 * @return
	 * @throws ParseException
	 */
    public static int daysBetween(Date bdate,Date edate) throws ParseException {    
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
       bdate = sdf.parse(sdf.format(bdate));  
       edate = sdf.parse(sdf.format(edate));  
       Calendar cal = Calendar.getInstance();    
       cal.setTime(bdate);    
       long time1 = cal.getTimeInMillis();                 
       cal.setTime(edate);    
       long time2 = cal.getTimeInMillis();         
       long between_days = (time2-time1)/(1000*3600*24);  
       return Integer.parseInt(String.valueOf(between_days));           
    }
    
    //获取指定秒后的时间
    public static Date getNextSecondTime(int second) {
		return new Date(new Date().getTime() + second*1000);
	}
    
	/**
	 * 获得昨天的开始时间
	 * 
	 * @return
	 */
	public static Date getYesterdayStartTime() {
		Date now = new Date();
		GregorianCalendar cal = new GregorianCalendar();
		try {
			cal.setTime(now);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			Date yesterday = cal.getTime();
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			StringUtils.dateTimeToString(now, "yyyyMMddHHmmss");
			now = shortSdf.parse(shortSdf.format(yesterday));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得昨天的结束时间
	 * 
	 * @return
	 */
	public static Date getYesterdayEndTime() {
		Date now = new Date();
		GregorianCalendar cal = new GregorianCalendar();
		try {
			cal.setTime(now);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			Date yesterday = cal.getTime();
			SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			now = longSdf.parse(shortSdf.format(yesterday) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获取两个时间段之间的日期集合
	 * 
	 * @throws ParseException
	 */
	public static List<Date> getDateListInPeriod(Date startDate, Date endDate) throws ParseException {
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> lDate = new ArrayList<Date>();
		lDate.add(startDate);
		Calendar calBegin = Calendar.getInstance();
		calBegin.setTime(shortSdf.parse(shortSdf.format(startDate)));
		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(shortSdf.parse(shortSdf.format(endDate)));
		// 测试此日期是否在指定日期之后
		while (endDate.after(calBegin.getTime())) {
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			lDate.add(shortSdf.parse(shortSdf.format(calBegin.getTime())));
		}
		return lDate;
	}

	/**
	 * 获得某天的开始时间
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getDayStartTime(Date startDate) throws ParseException {
		Date startTime = StringUtils.stringToDate(StringUtils.dateTimeToString(startDate, "yyyy-MM-dd" + " 00:00:00"), "yyyy-MM-dd HH:mm:ss");
		return startTime;
	}

	/**
	 * 获得某天的结束时间
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getDayEndTime(Date endDate) throws ParseException {
		Date endTime = StringUtils.stringToDate(StringUtils.dateTimeToString(endDate, "yyyy-MM-dd") + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
		return endTime;
	}
	

}