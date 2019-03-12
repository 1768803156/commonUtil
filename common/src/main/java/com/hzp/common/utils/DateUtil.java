package com.hzp.common.utils;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    /**
     * 时间转时间戳(单位秒)
     */
    public static long getDateStampByFormat(String datestr, String format) {
        long dateStamp = 0;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.CHINA);
            Date date = simpleDateFormat.parse(datestr);
            dateStamp = date.getTime() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStamp;

    }

    /**
     * 时间戳转时间(时间戳单位秒)
     */
    public static String stamp2Date(String dateStamp, String format) {
        if (TextUtils.isEmpty(dateStamp)) return "";
        String datestr = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.CHINA);
            datestr = simpleDateFormat.format(new Date(StringUtils.string2long(dateStamp) * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datestr;
    }

    /**
     * 时间戳转时间(时间戳单位秒) 若跨年也显示全部
     */
    @Deprecated
    public static String stamp2Date2(String dateStamp, String format) {
        if (TextUtils.isEmpty(dateStamp)) return "";
        String datestr = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.CHINA);
            datestr = simpleDateFormat.format(new Date(StringUtils.string2long(dateStamp) * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datestr;
    }

    public Date time2Date(String time, String format) {
        Date date = new Date();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.CHINA);
            date = simpleDateFormat.parse(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToStamp(String s, String fformat, String tformat) {
        if (TextUtils.isEmpty(s)) return s;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fformat, Locale.CHINA);
            Date date = simpleDateFormat.parse(s);
            return getStringByFormat(date, tformat);
        } catch (Exception e) {
            e.printStackTrace();
            return s;
        }
    }

    public static Date timeToDate(String time, String format) {
        Date date = new Date();
        if (TextUtils.isEmpty(time)) return date;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.CHINA);
            date = simpleDateFormat.parse(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


    public static String getStringByFormat(Date date, String format) {
        String strDate = "";
        try {
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format, Locale.CHINA);
            strDate = mSimpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate;
    }

    public static String getTodayDateStamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTimeInMillis() / 1000 + "";

    }

    /**
     * 时间戳转星期
     */
    public static String stamp2Week(String dateStamp) {
        if (TextUtils.isEmpty(dateStamp)) return "";
        String datestr = "";
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(StringUtils.string2long(dateStamp) * 1000));
            int intTemp = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            switch (intTemp) {
                case 0:
                    datestr = "周日";
                    break;
                case 1:
                    datestr = "周一";
                    break;
                case 2:
                    datestr = "周二";
                    break;
                case 3:
                    datestr = "周三";
                    break;
                case 4:
                    datestr = "周四";
                    break;
                case 5:
                    datestr = "周五";
                    break;
                case 6:
                    datestr = "周六";
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datestr;
    }

    public static String getTimeFromDate(Date date, String pattern) {
        String res = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);
            res = simpleDateFormat.format(date);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return res;
    }

    //显示星期 若是今天显示今天
    public static String stamp2Week2(String dateStamp) {
        if (TextUtils.isEmpty(dateStamp)) return "";

        String datestr = "";
        try {
            long dateStampl = Long.parseLong(dateStamp) * 1000;
            long nowL = System.currentTimeMillis();
            long oneday = 1000 * 60 * 60 * 24;
            if (nowL - dateStampl < oneday && nowL - dateStampl > 0) {
                datestr = "今天";
            } else if (dateStampl - nowL < 1000 * 60 * 60 * 24) {
                datestr = "明天";
            } else {
                datestr = stamp2Week(dateStamp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datestr;
    }

    public static String getNowDate(String part) {
        SimpleDateFormat _format = new SimpleDateFormat(part, Locale.CHINA);
        long currentTime = System.currentTimeMillis();
        Date date = new Date(currentTime);
        return _format.format(date);
    }

    public static int getMonthDays(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);//把时间往前减一天,就是2月的最后一天
        return calendar.get(Calendar.DAY_OF_MONTH);
    }


    public static void main(String[] args) {

        long dd = DateUtil.getDateStampByFormat("20180101", "yyyyMMdd");
        System.out.println("---yyyy-MM-dd HH:mm:ss--------         " + dd);
        System.out.println("---------            " + DateUtil.stamp2Date(dd + "", "yyyyMMdd"));
    }

}
