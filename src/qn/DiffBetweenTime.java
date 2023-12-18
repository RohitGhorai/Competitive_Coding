package qn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DiffBetweenTime {
    public static void main(String[] args) throws ParseException {
        String time1 = "2019-01-01 15:45:56";
        String time2 = "2019-01-01 15:46:56";
        timeDiff(time1, time2);
    }

    // Using SimpleDateFormat class
    static void timeDiff(String start, String stop) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = simpleDateFormat.parse(start);
        Date date2 = simpleDateFormat.parse(stop);
        long diffInMilliSec = Math.abs(date2.getTime() - date1.getTime());

//        long diffInHours = (diffInMilliSec /(60 * 60 * 1000)) % 24;
//        long diffInMinutes = (diffInMilliSec / (60 * 1000)) % 60;
//        long diffInSeconds = (diffInMilliSec / 1000) % 60;
//        System.out.println(start + " - " + stop + " = " + diffInHours + ":" + diffInMinutes + ":" + diffInSeconds);

        long diffInSec = diffInMilliSec / 1000;
        long diffInMin = diffInMilliSec / (1000 * 60);
        long diffInHour = diffInMilliSec / (1000 * 60 * 60);
        long totalDiff = 2 * diffInSec;
        System.out.println(totalDiff);
    }
}
