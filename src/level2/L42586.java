package level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 제목 : 기능개발
 * 설명 : 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 * <p>
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 * <p>
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 */
public class L42586 {

  public static void main(String[] args) {
    System.out.println(
      new L42586().solution(
        new int[]{93, 30, 55}, new int[]{1, 30, 5}
      )
    );
  }

  public int[] solution(int[] progresses, int[] speeds) {
    Queue<Integer> resultQueue = new LinkedList<>();
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < speeds.length; i++) {
      queue.add(getTotal(progresses[i], speeds[i]));
    }

    int j = 0;
    int qCount = 0;
    while (!queue.isEmpty()) {
      if (j == 0) {
        j = queue.peek(); // 현재값 입력
        queue.poll(); // 현재값 삭제
        qCount++;
      } else {
        if (queue.peek() - j > 0) {
          // 새롭게
          resultQueue.add(qCount);
          j = queue.peek();
          queue.poll(); // 현재값 삭제
          qCount = 1;

        } else {
          // 합산
          qCount++;
          queue.poll(); // 현재값 삭제
        }
      }
    }

    if (qCount != 0) {
      resultQueue.add(qCount);
    }

    return resultQueue.stream().mapToInt(Integer::intValue).toArray();
  }

  public static int getTotal(int progress, int speed) {
    int total = 0;
    while (progress + (speed * total) < 100) {
      total++;
    }

    return total;
  }


}
