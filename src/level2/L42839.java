package level2;

import java.util.HashSet;
import java.util.Set;

/**
 * 제목 : 소수 찾기
 * 설명 : 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * <p>
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 */
public class L42839 {

  public static void main(String[] args) {
    System.out.println(
      new L42839().solution(
        //"17" // 3
        "011" // 2
      )
    );
  }

  public int solution(String numbers) {
    int answer = 0;
    Set<Integer> list = new HashSet<>();
    for (int i = 1; i <= numbers.length(); i++) {
      johap("", numbers, i, list);
    }

    for (int i : list) {
      if (isSosu(i)) answer++;
    }

    return answer;
  }

  // 소수 여부 판단
  public static boolean isSosu(int num) {
    if (num <= 1) return false;

    for (int i = 2; i < num; i++) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }

  // 조합
  private static void johap(String prefix, String str, int length, Set<Integer> list) {
    if (prefix.length() == length) {
      list.add(Integer.parseInt(prefix));
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      johap(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), length, list);
    }
  }


}
