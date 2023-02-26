package org.example.yqgtest.util;

import com.yqg.common.util.clock.YqgClock;

public class TimeUtilTest {

  public static void main(String[] args) {
//    long start = 1664251713000L;
//    long end = 1664338113000L - 2;
    long start = YqgClock.now();
    long end = YqgClock.getMaxMillisOfDay(start);
    int days = YqgClock.getCalenderDaysBetween(start, end);
    String timeString = YqgClock.dateString(YqgClock.now(), "HH:mm:ss");
    long date = YqgClock.dateStringToLong("2023-08-27", "yyyy-MM-dd");
  }

}
