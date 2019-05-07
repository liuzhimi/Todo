package com.lzm.todo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuzhimi
 * @date 2019/5/7
 */
public class TimeUtils {

    private static SimpleDateFormat ymd = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
    private static SimpleDateFormat hm = new SimpleDateFormat("HH:mm");

    public static String getYMD(long mills){
        Date date = new Date(mills);
        return ymd.format(date);
    }

    public static String getHM(long mills){
        return hm.format(new Date(mills));
    }
}
