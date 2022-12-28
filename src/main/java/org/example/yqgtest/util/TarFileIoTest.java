package org.example.yqgtest.util;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class TarFileIoTest {

  public static void main(String[] args) throws Exception {
    File originFile = new File("/Users/yqg/Downloads/loanImageBackC2818742504167075840.tar");
    FileInputStream fileInputStream = new FileInputStream(originFile);
    byte[] file = IOUtils.toByteArray(fileInputStream);
    try (ByteArrayInputStream bos = new ByteArrayInputStream(file);
         TarArchiveInputStream inputStream = new TarArchiveInputStream(bos)) {
      TarArchiveEntry entry;
      while ((entry = inputStream.getNextTarEntry()) != null) {
        if (entry.isDirectory()) {
          continue;
        }
        long size = entry.getSize();
        // loanAgreement.pdf
        // payVoucher.pdf
        String name = "loanAgreement.pdf";
        if (name.equals(entry.getName())) {
          byte[] tmp = new byte[(int)size];
          inputStream.read(tmp);
          FileOutputStream fileOutputStream = new FileOutputStream("/Users/yqg/Downloads/" + name);
          fileOutputStream.write(tmp);
        } else {
          inputStream.skip(size);
        }
      }
    } catch (Exception e) {
      throw new Exception("解析资方的tar文件失败", e);
    }
  }
}
