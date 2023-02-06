package org.example.yqgtest.util;

import com.yqg.common.util.clock.YqgClock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class TimeTest {
  public static void main(String[] args) {
    LocalTime localTime = LocalTime.parse("01:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
    int value = localTime.get(ChronoField.MILLI_OF_DAY);
    System.out.println(localTime.getLong(ChronoField.MILLI_OF_DAY));
    System.out.println(YqgClock.getMinMillisOfDay(YqgClock.now()));
  }
}
