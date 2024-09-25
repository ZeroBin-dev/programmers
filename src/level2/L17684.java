package level2;

import java.util.*;

/**
 * 제목 : 압축
 * 설명 : 신입사원 어피치는 카카오톡으로 전송되는 메시지를 압축하여 전송 효율을 높이는 업무를 맡게 되었다.
 * 메시지를 압축하더라도 전달되는 정보가 바뀌어서는 안 되므로, 압축 전의 정보를 완벽하게 복원 가능한 무손실 압축 알고리즘을 구현하기로 했다.
 * <p>
 * 어피치는 여러 압축 알고리즘 중에서 성능이 좋고 구현이 간단한 LZW(Lempel–Ziv–Welch) 압축을 구현하기로 했다. LZW 압축은 1983년 발표된 알고리즘으로,
 * 이미지 파일 포맷인 GIF 등 다양한 응용에서 사용되었다.
 * <p>
 * LZW 압축은 다음 과정을 거친다.
 * <p>
 * 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
 * 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
 * w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
 * 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
 * 단계 2로 돌아간다.
 * 압축 알고리즘이 영문 대문자만 처리한다고 할 때, 사전은 다음과 같이 초기화된다. 사전의 색인 번호는 정수값으로 주어지며, 1부터 시작한다고 하자.
 */
public class L17684 {

  public static void main(String[] args) {
    System.out.println(
      new L17684().solution(
        "TOBEORNOTTOBEORTOBEORNOT"
      )
    );
  }

  /**
   * 현재 입력(w)	다음 글자(c)	출력	사전 추가(w+c)
   * K	A	11	27: KA
   * A	K	1	28: AK
   * KA	O	27	29: KAO
   * O		15
   * */

  public int[] solution(String msg) {
    ArrayList<Integer> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (int i = 1; i <= 26; i++) {
      map.put(Character.toString(i + 64), i);
    }

    int index = 27;

    String tot = "";
    for(int i = 0 ; i < msg.length() ; i++){
      String cur = tot + msg.charAt(i); // 현재글자
      String next = i != msg.length() -1 ? String.valueOf(msg.charAt(i+1)) : ""; // 다음글자

      // 사전에 있음
      if(map.containsKey(cur+next)){
        tot = cur;
        if(i == msg.length()-1){
          result.add((map.get(cur)));
        }
      } else {
        // 사전에 없음
        map.put(cur+next, index++);
        result.add(map.get(cur));
        tot = "";
      }

    }


    return result.stream().mapToInt(Integer::intValue).toArray();
  }


}
