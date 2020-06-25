package com.madhouse.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-05 11:22
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        System.out.println(new Date(1577120537000L));
        String time ="2019-12-23 17:02:17";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.parse(time).getTime());
    }
}
