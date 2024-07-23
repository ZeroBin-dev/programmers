package level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 제목 : 다리를 지나는 트럭
 * 설명 : 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
 * 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
 * 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
 */
public class L42583 {

  public static void main(String[] args) {
    System.out.println(
      new L42583().solution(
        //10, 100, new int[]{50, 30, 10, 10, 30, 10, 40} // 23
        2, 10, new int[]{7,4,5,6} // 23
      )
    );
  }

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    // 대기큐 생성 및 초기화
    Queue<Integer> waitQ = new LinkedList<>();
    for (int w : truck_weights) {
      waitQ.add(w);
    }

    // 건너큐생성
    Queue<int[]> ingQ = new LinkedList<>();

    // 시간 생성
    int time = 0;
    int totalWeight = 0;

    while (!waitQ.isEmpty() || !ingQ.isEmpty()) {
      time++;

      // 다리를 다 건넌 차가 있는지 체크
      if (!ingQ.isEmpty() && ingQ.peek()[1] == time) {
        totalWeight -= ingQ.poll()[0];
      }

      // 새로운 트럭이 다리위에 올라갈 수 있는지 체크
      if (!waitQ.isEmpty() && totalWeight + waitQ.peek() <= weight) {
        int truckWeight = waitQ.poll();
        totalWeight += truckWeight;
        // 현재 시간 + 다리 길이 = 다리를 건너는 시간을 계산하여 저장
        ingQ.add(new int[]{truckWeight, time + bridge_length});
      }
    }

    return time;
  }


}
