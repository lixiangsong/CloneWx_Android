package song.com.cn.clonewx_andorid.utils;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by on 2015/2/25.
 */
public abstract class DateUtil {
    /*
    * 将时间戳转换为时间
    */
    public static String stampToDate(long s) {
        if (isToday(s)) {
            return "今天";
        } else if (isYesterday(s)) {
            return "昨天";
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(s);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 获取当前日期
     */
    public static String getDate() {
        return DateFormat.format("yyyy-MM-dd", Calendar.getInstance()).toString();
    }

    public static boolean isToday(long date) {
        long now = System.currentTimeMillis();
        long diff = (now - date) / 1000;
        if (diff >= 86400 || diff <= 0) return false;
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(now);
        Calendar c2 = Calendar.getInstance();
        c2.setTimeInMillis(date);
        return c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR);
    }

    public static boolean isYesterday(long timestamp) {
        Calendar c = Calendar.getInstance();
        clearCalendar(c, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND);
        c.add(Calendar.DAY_OF_MONTH, -1);
        long firstOfDay = c.getTimeInMillis(); // 昨天最早时间

        c.setTimeInMillis(timestamp);
        clearCalendar(c, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND); // 指定时间戳当天最早时间

        return firstOfDay == c.getTimeInMillis();
    }

    private static void clearCalendar(Calendar c, int... fields) {
        for (int f : fields) {
            c.set(f, 0);
        }
    }

    public static int getSysYear() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.YEAR);
    }

    public static int getSysMonth() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.MONTH) + 1;
    }

    public static int getSysDay() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.DAY_OF_MONTH);
    }


}
