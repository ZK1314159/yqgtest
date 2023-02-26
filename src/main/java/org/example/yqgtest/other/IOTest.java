package org.example.yqgtest.other;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

public class IOTest {

  public static void main(String[] args) throws Exception {
    String test = "hhsfjkdjfkdfk\nnhdkjfjffjdfkk\n";
    byte[] data = test.getBytes(Charset.forName("UTF-8"));
    ByteArrayInputStream bis = new ByteArrayInputStream(data);
    InputStreamReader inputStreamReader = new InputStreamReader(bis);
    BufferedReader reader = new BufferedReader(inputStreamReader);
    List<String> list = IOUtils.readLines(reader);
  }

}
