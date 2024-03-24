package com.yugi.common.utils;

import com.yugi.common.consts.DateFormat;
import com.yugi.common.enums.Msg;
import com.yugi.common.exception.YugiAssert;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 时间工具类
 *
 * @author tdd
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    /**
     * 获取当前格式日期
     *
     * @param format 日期格式
     * @return 当前格式日期（str）
     */
    public static String getNowDate(String format) {
        return parseDate(format, LocalDateTime.now());
    }

    /**
     * 获取当前日期数字
     *
     * @param format 日期格式
     * @return 当前格式日期（int）
     */
    public static Integer getNowDigit(String format) {
        YugiAssert.cast(!Arrays.asList(DateFormat.YMD).contains(format), Msg.ERR_FORMAT);
        String result = parseDate(format, LocalDateTime.now());
        return Integer.parseInt(result);
    }

    /**
     * 获取格式日期
     *
     * @param format 日期格式
     * @param date   日期
     * @return 格式日期
     */
    public static String parseDate(String format, LocalDateTime date) {
        return DateTimeFormatter.ofPattern(format).format(date);
    }

    /**
     * 获取当前日期时间戳
     *
     * @return 时间戳
     */
    public static long getTimestamp() {
        return LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    /**
     * 获取指定日期时间戳
     *
     * @param dateTime
     * @return
     */
    public static long getTimestamp(LocalDateTime dateTime) {
        return dateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    /**
     * 获取日期
     *
     * @param date 日期（str）
     * @return 日期
     */
    public static Date getDate(final String date) {
        try {
            return parseDate(date, DateFormat.PATTERNS);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 增加月数
     *
     * @param date 日期
     * @param i    月数
     * @return 增加日期
     */
    public static Date addMonth(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, i);
        return calendar.getTime();
    }

    /**
     * 获取时间差
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 时间差（ps：5270400000）
     */
    public static long getSubtraction(Date start, Date end) {
        return end.getTime() - start.getTime();
    }

    /**
     * 获取当前年月份
     *
     * @return 月份列表（ps：[1, 2, 3]
     */
    public static List getMonthList(){
        List list = new ArrayList();
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        for (int i = 1; i <= month; i++) {
            list.add(i);
        }
        return list;
    }


    public static void main(String[] args) {
        Date date = DateUtils.addMonth(new Date(), 2);
        List list = DateUtils.getMonthList();
        System.out.println(list);
    }
}
