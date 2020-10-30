package cn.yunhe.java.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static final  String FORMATE = "yyyy-MM-dd HH:mm:ss";
    private static SimpleDateFormat sdf = new SimpleDateFormat(FORMATE);

    private static final String dataFormatStr = "yyyy-MM-dd HH:mm:ss";

    private static DateFormat sysDate = new SimpleDateFormat("yyyy-MM-dd");
    private static DateFormat sysMonth = new SimpleDateFormat("yyyy-MM");
    private static DateFormat sysDateTime = new SimpleDateFormat(dataFormatStr);

    public static String getSystemDate(){
        return sdf.format(new Date());
    }

    /**
     * 获取系统当前时间
     * @return
     */
    public static String getSystemDateTime() {
        return sysDateTime.format(new Date());
    }

    //获取系统的当前时间
    public static String currentTime() {
        Date today = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        return dateformat.format(today);

    }

    /**
     * 根据格式获取系统当前时间
     * @param format
     * @return
     */
    public static String getSystemDateTimeByFormat(String format){
        return (new SimpleDateFormat(format)).format(new Date());
    }

    /**
     * 根据格式获取给定时间的字符串形式
     * @return
     */
    public static String getSystemDateTime(Date date) {
        return sysDateTime.format(date);
    }

    /**
     * 获取当前月分第一天的日期
     * @return
     */
    public static String getFirstDayOfMonth() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, 1);
        return sysDate.format(c.getTime());
    }

    /**
     * 获取当前月分最后一天的日期
     * @return 当月最后一天字符串
     */
    public static String getLastDayOfMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DATE, 1);
        c.add(Calendar.DATE, -1);
        return sysDate.format(c.getTime());
    }

    /**
     *  获取当前日期的前后N天日期
     * @param n
     * @return 如果n是大于0的整数，则返回当前日期往后第n天的日期
     * 		         如果n是小于0的整数，则返回当前日期往前第n天的日期
     */
    public static String getSpecialDate(int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, n);
        return sysDate.format( c.getTime());
    }

    /**
     * 获取系统当前月份上一个月的日期
     * @return 返回格式"yyyy-MM"
     */
    public static String getLastMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        return sysMonth.format(c.getTime());
    }

    /**
     * 获取系统当前月份
     * @return 返回格式"yyyy-MM"
     */
    public static String getYearMonth() {
        Calendar c = Calendar.getInstance();
        return sysMonth.format(c.getTime());
    }

    /**
     * 获取当前年份
     * @return
     */
    public static String getYear() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return format.format(c.getTime());
    }

    /**
     * 获取当前季度
     * @return 1：一季度 ， 2：二季度，3：三季度，4：四季度
     */
    public static int getNowJd() {
        Calendar now = Calendar.getInstance();
        int month = now.get(Calendar.MONTH) + 1;
        if (month == 1 || month == 2 || month == 3) {
            return 1;
        } else if (month == 4 || month == 5 || month == 6) {
            return 2;
        } else if (month == 7 || month == 8 || month == 9) {
            return 3;
        } else if (month == 10 || month == 11 || month == 12) {
            return 4;
        }
        return 0;
    }

    /**
     * 该方法用来计算两个时间相差几天
     * @param time1
     * @param time2
     * @return
     */
    public static long getDateTimeDayDiff(String time1, String time2) {
        long tianshu = 0;
        try {
            // 通过DateFormat将字符串时间转换成Date类型的日期时间
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date dateCreate = df.parse(time1);
            Date dateOver = df.parse(time2);
            // 将Date格式的时间设置为Calendar格式的日历格式，并使用Calendar类中的getTimeInMillis()方法得到对应的long类型
            Calendar cl = Calendar.getInstance();
            cl.setTime(dateCreate);
            long timeCreate = cl.getTimeInMillis();
            cl.setTime(dateOver);
            long timeOver = cl.getTimeInMillis();
            // 计算相差多少天
            tianshu = (timeOver - timeCreate) / 1000 / 3600 / 24;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tianshu;
    }


    /**
     * 两个时间相差秒数
     * @param time1
     * @param time2
     * @return
     */
    public static long secondDiff(String time1, String time2) {
        long miaoshu = 0;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Date dateCreate = df.parse(time1);
            Date dateOver = df.parse(time2);
            Calendar cl = Calendar.getInstance();
            cl.setTime(dateCreate);
            long timeCreate = cl.getTimeInMillis();
            cl.setTime(dateOver);
            long timeOver = cl.getTimeInMillis();
            miaoshu = (timeOver - timeCreate) / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return miaoshu;
    }

    /**
     * 当前年份+-操作
     * @param num
     * @return 如果num>0,则返回n年后的年份，如果num<0则返回n年前的年份
     */
    public static String getYear(int num) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, num);
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return format.format(c.getTime());
    }

    /**
     * 两个时间做比较，计算生效时间范围
     * @param num
     * @param type
     * @param date
     * @return
     */
    public static String getNextTimeStr(double num, int type, Date date) {
        long nowLong = date.getTime();
        Date time = new Date(nowLong + formatToTimeMillis(num, type));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(time);
        return str;
    }

    public static long formatToTimeMillis(double num, int type) {
        if (num <= 0)
            return 0;
        switch (type) {
            case 1:
                return (long) (num * 1000);
            case 2:
                return (long) (num * 60 * 1000);
            case 3:
                return (long) (num * 60 * 60 * 1000);
            case 4:
                return (long) (num * 24 * 60 * 60 * 1000);
            default:
                return -1;
        }
    }

    /**
     * 计算两个日期相差的天、时、分
     * @param endDate
     * @param nowDate
     * @return
     */
    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }
    /**
     * 查询当前时间几分钟前后时间
     *   x  几分钟后
     *   -x  几分钟前
     * @param
     * @return
     */
    public static String getDateTime(int num){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, num);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

    }

}
