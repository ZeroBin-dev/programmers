package practice;

import java.io.FileOutputStream;
import java.util.Base64;

public class BigStringParse {

  public static void main(String[] args) {
    // Base64로 인코딩된 이미지 데이터
    StringBuilder sb = new StringBuilder();

    // 저장할 이미지 파일 경로
    String imagePath = "D:\\개인폴더\\output.jpg";

    try {
      // Base64 디코딩
      byte[] imageData = Base64.getDecoder().decode(sb.toString());

      // 이미지 파일로 저장
      FileOutputStream outputStream = new FileOutputStream(imagePath);
      outputStream.write(imageData);
      outputStream.close();

      System.out.println("이미지 파일이 성공적으로 생성되었습니다.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
