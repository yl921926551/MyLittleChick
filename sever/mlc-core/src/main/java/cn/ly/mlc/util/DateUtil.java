package cn.ly.mlc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author shidewen
 * 日期工具类
 * 
 */
public class DateUtil {
	
    /**
     * 
     *
     * @Description: 获取指定日期的几天之前
     * @param @param NDay
     * @param @param date
     * @param @return
     * @throws
     */
    public static Date getNDayBefore(int NDay, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - NDay);

        return calendar.getTime();
    }

    /**
     * 
     *
     * @Description: 获取指定日期的几月之前或之后
     * @param @param NMonth
     * @param @param date
     * @param @return
     * @throws
     */
    public static Date getNMonth(int NMonth, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, NMonth);

        return calendar.getTime();
    }

    /**
     * 
     *
     * @Description: 根据制定格式解析字符串
     * @param @param date 日期
     * @param @param formatStr 格式
     * @param @return
     * @throws
     */
    public static String parseDateByFormat(Date date, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }

}
