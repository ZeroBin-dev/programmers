package level2;

import java.util.HashMap;
import java.util.Map;

/**
 * 제목 : 영어 끝말잇기
 * 설명 : 1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기를 하고 있습니다. 영어 끝말잇기는 다음과 같은 규칙으로 진행됩니다.
 *
 * 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
 * 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
 * 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
 * 이전에 등장했던 단어는 사용할 수 없습니다.
 * 한 글자인 단어는 인정되지 않습니다.
 * 다음은 3명이 끝말잇기를 하는 상황을 나타냅니다.
 *
 * tank → kick → know → wheel → land → dream → mother → robot → tank
 *
 * 위 끝말잇기는 다음과 같이 진행됩니다.
 *
 * 1번 사람이 자신의 첫 번째 차례에 tank를 말합니다.
 * 2번 사람이 자신의 첫 번째 차례에 kick을 말합니다.
 * 3번 사람이 자신의 첫 번째 차례에 know를 말합니다.
 * 1번 사람이 자신의 두 번째 차례에 wheel을 말합니다.
 * (계속 진행)
 */
public class L12981 {

  public static void main(String[] args) {
    System.out.println(
      new L12981().solution(
        3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}
      )
    );
  }

  public int[] solution(int n, String[] words) {
    Map<String, Integer> map = new HashMap<>();
    map.put(words[0], 1);

    int index = 0;
    for(int i = 1;i<words.length;i++){
      // 앞에 단어와 이어지지 않거나 이미 나온 단어인지 체크
      if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1) || map.get(words[i]) != null){
        index = i;
        break;
      } else {
        map.put(words[i], 1);
      }
    }

    int[] answer = new int[2];
    if(index != 0){
      answer[0] = index%n+1;
      answer[1] = index/n+1;
    }

    return answer;
  }


}
