package utils;

import org.apache.commons.lang3.time.DateUtils;

import java.util.*;

public class MyDateUtils {

    public static List<Date> getDateByDay(Date date) {
        List<Date> dates = new ArrayList<>();
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(date);
        setTimeToBeginningOfDay(c);
        dates.add(c.getTime());
        setTimeToEndofDay(c);
        dates.add(c.getTime());
        return dates;
    }

    public static List<Date> getDateByWeek(Date endDate) {
        List<Date> dates = new ArrayList<>();
        Calendar c = GregorianCalendar.getInstance();
        Date startDate = DateUtils.addDays(endDate, -6);
        c.setTime(startDate);
        setTimeToBeginningOfDay(c);
        dates.add(c.getTime());
        c.setTime(endDate);
        setTimeToEndofDay(c);
        dates.add(c.getTime());
        return dates;
    }

    public static List<Date> getDateByMonth(Date endDate) {
        List<Date> dates = new ArrayList<>();
        Calendar c = GregorianCalendar.getInstance();
        Date startDate = DateUtils.addDays(endDate, -29);
        c.setTime(startDate);
        setTimeToBeginningOfDay(c);
        dates.add(c.getTime());
        c.setTime(endDate);
        setTimeToEndofDay(c);
        dates.add(c.getTime());
        return dates;
    }

    public static List<Date> getDateByDay() {
        List<Date> dates = new ArrayList<>();
        Calendar c = GregorianCalendar.getInstance();
        setTimeToBeginningOfDay(c);
        dates.add(c.getTime());
        setTimeToEndofDay(c);
        dates.add(c.getTime());
        return dates;
    }

    public static List<Date> getDateByWeek() {
        List<Date> dates = new ArrayList<>();
        Calendar c = GregorianCalendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        setTimeToBeginningOfDay(c);
        dates.add(c.getTime());
        c.add(Calendar.DATE, 6);
        setTimeToEndofDay(c);
        dates.add(c.getTime());
        return dates;
    }

    public static List<Date> getDateByMonth() {
        List<Date> dates = new ArrayList<>();
        Calendar c = GregorianCalendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        setTimeToBeginningOfDay(c);
        dates.add(c.getTime());
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        setTimeToEndofDay(c);
        dates.add(c.getTime());
        return dates;
    }

    private static void setTimeToBeginningOfDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    private static void setTimeToEndofDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
    }
}
