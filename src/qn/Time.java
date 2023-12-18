package qn;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public static Time difference(Time start, Time stop){
        Time diff = new Time(0, 0, 0);
        if(start.seconds > stop.seconds){
            --stop.minutes;
            stop.seconds += 60;
        }
        diff.seconds = stop.seconds - start.seconds;
        if(start.minutes > stop.minutes){
            --stop.hours;
            stop.minutes += 60;
        }
        diff.minutes = stop.minutes - start.minutes;
        diff.hours = stop.hours - start.hours;
        return diff;
    }
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public static void main(String[] args) {
        Time start = new Time(15, 45, 56);
        Time stop = new Time(15, 46, 56);
        Time diff = difference(start, stop);
        System.out.printf("%d:%d:%d - ", start.hours, start.minutes, start.seconds);
        System.out.printf("%d:%d:%d = ", stop.hours, stop.minutes, stop.seconds);
        System.out.printf("%d:%d:%d", diff.hours, diff.minutes, diff.seconds);
//        long hour = diff.hours + (diff.minutes / 60) + (diff.seconds / (60 * 60));
//        long minutes = (diff.hours * 60L) + diff.minutes + (diff.seconds / 60);
//        long seconds = (diff.hours * 3600L) + (diff.minutes * 60L) + diff.seconds;
//        System.out.println("IN HOURS = " + hour);
//        System.out.println("IN MINUTES = " + minutes);
//        System.out.println("IN SECONDS = " + seconds);
    }
}
