package org.example.yqgtest.util;

import com.yqg.core.util.MD5;

public class Md5Test {
  public static void main(String[] args) {
    System.out.println(MD5.encrypt("6217001360835939043-18516116846-113212199901018415-白聪-XS_BANK-413"));
    System.out.println(MD5.encrypt("6217001360835939043-18516116846-113212199901018415-白聪-CCB-XS_BANK"));
  }

}
