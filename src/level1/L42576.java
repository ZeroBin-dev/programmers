package level1;

import java.util.HashMap;
import java.util.Map;

/**
 * 제목 : 완주하지 못한 선수
 * 설명 : 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * <p>
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 */

public class L42576 {

  public static void main(String[] args) {
    System.out.println(
      new L42576().solution(
        new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}
      )
    );
  }

  public String solution(String[] participant, String[] completion) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < participant.length; i++) {
      int num = map.getOrDefault(participant[i], 0);
      map.put(participant[i], ++num);
    }

    for (int i = 0; i < completion.length; i++) {
      int num = map.getOrDefault(completion[i], 0);
      map.put(completion[i], --num);
    }

    // value 가 1인 데이터를 찾기
    for (String key : map.keySet()) {
      if (map.get(key) == 1) {
        return key;
      }
    }

    return "";
  }
}
