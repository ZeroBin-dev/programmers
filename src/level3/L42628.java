package level3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 제목 : 이중우선순위큐
 * 설명 : 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
 */

public class L42628 {

  public static void main(String[] args) {
    System.out.println(
      new L42628().solution(
        new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}
      )
    );
  }

  public int[] solution(String[] operations) {
    PriorityQueue<Integer> minQ = new PriorityQueue<>();
    PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());

    for (String oper : operations) {
      int v = Integer.parseInt(oper.split(" ")[1]);

      // I 로 시작하면 숫자 입력
      if (oper.startsWith("I")) {
        minQ.add(v);
        maxQ.add(v);
      }

      // D 로 시작하면 숫자 삭제
      else {
        // 최대값 삭제
        if (v > 0) {
          minQ.remove(maxQ.poll());
        }

        // 최소값 삭제
        else {
          maxQ.remove(minQ.poll());
        }
      }

    }

    int[] answer = {};
    int min = minQ.size() > 0 ? minQ.peek() : 0;
    int max = maxQ.size() > 0 ? maxQ.peek() : 0;

    return new int[]{max, min};
  }

}
