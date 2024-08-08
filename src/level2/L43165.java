package level2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 제목 : 타겟 넘버
 * 설명 : n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
 * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 */
public class L43165 {

  public static void main(String[] args) {
    System.out.println(
      new L43165().solution(
        new int[]{1, 1, 1, 1, 1}, 3
      )
    );
  }

  public int solution(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(numbers[0], 1);
    map.put(-numbers[0], 1);

    for (int i = 1; i < numbers.length; i++) {
      Map<Integer, Integer> tempMap = new HashMap<>(map);
      map.clear();

      for (int key : tempMap.keySet()) {
        int count = tempMap.get(key);
        map.put(key + numbers[i], map.getOrDefault(key + numbers[i], 0) + count);
        map.put(key - numbers[i], map.getOrDefault(key - numbers[i], 0) + count);
      }
    }

    return map.getOrDefault(target, 0);
  }


}
