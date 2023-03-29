package org.example.yqgtest.util;

import com.yqg.common.util.clock.YqgClock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtilTest {

  public static void main(String[] args) {
//    long start = 1664251713000L;
//    long end = 1664338113000L - 2;
    long start = YqgClock.now();
    long end = YqgClock.getMaxMillisOfDay(start);
    int days = YqgClock.getCalenderDaysBetween(start, end);
    String timeString = YqgClock.dateString(YqgClock.now(), "HH:mm:ss");
    long date = YqgClock.dateStringToLong("2023-08-27", "yyyy-MM-dd");
    String[] cell = new String[] {"20230827", "jkfjdf"};
    TimeUtilTest timeUtilTest = new TimeUtilTest();
    LocalDateTime localDateTime = timeUtilTest.test(cell);
  }

  public LocalDateTime test(String[] cell) {
    LocalDate dateTime = LocalDate.parse(cell[0], DateTimeFormatter.ofPattern("yyyyMMdd"));
    dateTime = dateTime.minusDays(1);
    return dateTime.atStartOfDay();
  }

}
