package practice;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileDown {

  public static void main(String[] args) {
    String fileURL = "https://scheduler.health.kr/api/v1/download/04b85c9866834608afe27b172085d86a";
    String saveDir = "D:\\개인폴더\\약정원데이터\\";
    String lastFileDir = "D:\\개인폴더\\약정원데이터\\lastFile.txt";
    String readyFileDir = "D:\\개인폴더\\약정원데이터\\ready.txt";

    try {
      // 원격 파일의 크기 가져오기
      long remoteFileSize = getRemoteFileSize(fileURL);
      System.out.println("Remote file size: " + remoteFileSize);

      // 로컬 파일의 내용 가져오기
      String localFileContent = getLocalFileContent(lastFileDir);
      System.out.println("Local file content: " + localFileContent);

      // 로컬 파일의 내용과 원격 파일의 크기 비교
      if (!localFileContent.equals(String.valueOf(remoteFileSize))) {
        // 파일 다운로드 및 압축 해제
        downloadAndUnzip(fileURL, saveDir);

        // ready.txt에 "complete" 작성
        writeToFile(readyFileDir, "complete");

        // lastFile.txt에 원격 파일의 크기 작성
        updateLastModified(lastFileDir, String.valueOf(remoteFileSize));
      }
    } catch (Exception e) {
      System.out.println("Error downloading or moving file: " + e.getMessage());
    }
  }

  public static long getRemoteFileSize(String fileURL) throws IOException {
    URL url = new URL(fileURL);
    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
    return connection.getContentLengthLong();
  }

  public static String getLocalFileContent(String filePath) throws IOException {
    StringBuilder content = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        content.append(line);
      }
    }
    return content.toString();
  }

  public static void downloadAndUnzip(String fileURL, String saveDir) throws Exception {
    // 파일 다운로드
    String fileName = getFileNameFromHeader(fileURL);
    String saveFilePath = saveDir + fileName;
    downloadFile(fileURL, saveFilePath);

    // 압축 해제
    unzip(saveFilePath, saveDir);
  }

  public static String getFileNameFromHeader(String fileURL) throws IOException {
    URL url = new URL(fileURL);
    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
    String disposition = connection.getHeaderField("Content-Disposition");
    String fileName = null;
    if (disposition != null && disposition.contains("filename=")) {
      int index = disposition.indexOf("filename=");
      fileName = disposition.substring(index + 10, disposition.length() - 1);
    } else {
      // 헤더에 파일 이름이 없는 경우 URL에서 추출
      fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1);
    }
    return fileName;
  }

  public static void downloadFile(String fileURL, String saveFilePath) throws IOException {
    URL url = new URL(fileURL);
    try (InputStream in = url.openStream();
         FileOutputStream out = new FileOutputStream(saveFilePath)) {
      byte[] buffer = new byte[1024];
      int bytesRead;
      while ((bytesRead = in.read(buffer)) != -1) {
        out.write(buffer, 0, bytesRead);
      }
    }
  }

  public static void unzip(String zipFilePath, String destDir) throws IOException {
    byte[] buffer = new byte[1024];
    try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
      ZipEntry zipEntry = zis.getNextEntry();
      while (zipEntry != null) {
        String fileName = zipEntry.getName();
        File newFile = new File(destDir + File.separator + fileName);
        try (FileOutputStream fos = new FileOutputStream(newFile)) {
          int len;
          while ((len = zis.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
          }
        }
        zipEntry = zis.getNextEntry();
      }
      zis.closeEntry();
    }
  }

  public static void writeToFile(String filePath, String content) throws IOException {
    try (FileWriter writer = new FileWriter(filePath)) {
      writer.write(content);
    }
  }

  public static void updateLastModified(String filePath, String content) throws IOException {
    Files.write(Paths.get(filePath), content.getBytes());
  }
}
