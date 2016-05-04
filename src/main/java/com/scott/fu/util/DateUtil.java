package com.scott.fu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ScottFu on 2015/12/24.
 */
public class DateUtil {
    private static SimpleDateFormat simpleDateFormat;

    private static DateUtil dateUtil;

    private static String formatTemp = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String DATE_TIME_SEC = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_TIME_SEC_CN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_SEC_MILLI = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String YEAR_MONTH_DATE = "yyyy/MM/dd";

    private DateUtil() {
        simpleDateFormat = new SimpleDateFormat(formatTemp);
    }
    private DateUtil(String format) {
        formatTemp = format;
        simpleDateFormat = new SimpleDateFormat(formatTemp);
    }

    public static DateUtil getInstance(Object... param) {
        String formatNew = null;
        if(param.length != 0) {
            formatNew = (String)param[0];
        }
        if(formatNew == null || formatNew.equals ("")) {
            if(dateUtil == null) {
                dateUtil = new DateUtil();
            }
        } else {
            if(!formatNew.equals(formatTemp)) {
                dateUtil = new DateUtil(formatNew);
            }
        }
        return dateUtil;
    }

    public String format(Date date) {
        return simpleDateFormat.format(date);
    }

    public Date parse(String dateStr) {
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
