package org.example.yqgtest.util;

import com.yqg.common.util.clock.YqgClock;

public class StringReplaceTest {

  public static void main(String[] args) {
    String string = "njyhrw:nBpOu8x6yNk%40RwwT@47.95.66.238:50090/data";
    String strinf = string.replace("%", "%%");
    String result = String.format("sftp://%s/njcb/yqg/files/%s/", string, 111);
  }

}
