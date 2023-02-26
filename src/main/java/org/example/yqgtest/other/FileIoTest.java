package org.example.yqgtest.other;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;

public class FileIoTest{

  public static final String LINE_SEPARATOR = "\n";
  public static final String SEPARATOR_REGEX = "\\|";
  public static final String SEPARATOR = "|";

  public static void main(String[] args) throws Exception {
    File file = new File("/Users/yqg/Downloads/YQG-REPAY-20230827.txt");
    FileInputStream fileInputStream = new FileInputStream(file);
    byte[] bytes = IOUtils.toByteArray(fileInputStream);
    String string = new String(bytes);
    String[] strings = string.split(LINE_SEPARATOR);
    String s1 = strings[0] + SEPARATOR + SEPARATOR;
    String s2 = strings[0] + SEPARATOR_REGEX + SEPARATOR_REGEX;
  }

}
