package com.weekmanager;
import java.util.*;
public class WeekGetter {
    public static long getWeeks(int[] from, int[] to)  {
        var cal1 = Calendar.getInstance();
        cal1.set(from[0],from[1],from[2]);
        var cal2 = Calendar.getInstance();
        cal2.set(to[0],to[1], to[2]);        
        return cal2.getTimeInMillis()/604800000-cal1.getTimeInMillis()/604800000;
    }  
        
}