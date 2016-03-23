package com.yoy.weatherclock.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/3/23.
 */
public class Tools {


    /**
     *
     * @param str
     * @return
     */
    public static String getNum(String str){
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            return matcher.group();
        }
        return "";
    }
}
