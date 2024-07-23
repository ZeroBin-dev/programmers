package practice;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ZipInfo {

  public static void main(String[] args) {
    String tarFilePath = "D:\\개인폴더\\약정원데이터\\cresoty2021.tar";
    printTarFileList(tarFilePath);
  }

  public static void printTarFileList(String tarFilePath) {
    ZipArchiveEntry entry = null;
    try (
      InputStream in = new FileInputStream(tarFilePath);
      ZipArchiveInputStream zais = new ZipArchiveInputStream(in, "UTF-8", true);
    ) {
      while ((entry = zais.getNextZipEntry()) != null) {
        Date lastModifiedDate = entry.getLastModifiedDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(lastModifiedDate);
        System.out.print("파일명 : [" + entry.getName() + "], 최종수정일 : [" + formattedDate + "]");
        System.out.println();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
