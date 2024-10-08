package level2;

import java.util.HashMap;
import java.util.Map;

/**
 * 제목 : 전화번호 목록
 * 설명 : 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 */
public class L42577 {

  public static void main(String[] args) {
    System.out.println(
      new L42577().solution(
        new String[]{"119", "97674223", "1195524421"}
      )
    );
  }

  public boolean solution(String[] phone_book) {
    if (phone_book.length == 1) {
      return true;
    }

    Map<String, Integer> map = new HashMap<>();
    for (String s : phone_book) {
      map.put(s, 1);
    }

    for (String s : phone_book) {
      for (int i = 1; i < s.length(); i++) {
        if (map.get(s.substring(0, i)) != null) {
          return false;
        }
      }
    }

    return true;
  }


}
