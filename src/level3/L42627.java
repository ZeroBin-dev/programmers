package level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 제목 : 디스크 컨트롤러
 * 설명 : 하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.
 */

public class L42627 {

  public static void main(String[] args) {
    System.out.println(
      new L42627().solution(
        new int[][]{{0, 3}, {1, 9}, {2, 6}}
      )
    );
  }

  public int solution(int[][] jobs) {
    Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

    PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.comparingInt(Task::getProcess));

    int time = 0; // 현재 시간
    int idx = 0; // jobs 배열의 인덱스
    int totalTime = 0; // 모든 작업의 대기 시간 총합

    // 모든 작업을 처리할 때까지 반복
    while (idx < jobs.length || !pq.isEmpty()) {
      // 현재 시간까지 요청된 모든 작업을 우선순위 큐에 추가
      while (idx < jobs.length && jobs[idx][0] <= time) {
        pq.add(new Task(jobs[idx][0], jobs[idx][1]));
        idx++;
      }

      // 처리할 작업이 있으면 작업을 처리
      if (!pq.isEmpty()) {
        Task currentTask = pq.poll();
        time += currentTask.getProcess(); // 현재 시간 갱신
        totalTime += time - currentTask.getStart(); // 대기 시간 총합 계산
      } else {
        // 처리할 작업이 없으면 시간 1초 증가
        time++;
      }
    }


    return totalTime / jobs.length;
  }

  private static class Task {
    private int start; // 시작시간
    private int process; // 소요시간

    public Task(int start, int process) {
      this.start = start;
      this.process = process;
    }

    public int getStart() {
      return this.start;
    }

    public int getProcess() {
      return this.process;
    }

    public void setStart(int start) {
      this.start = start;
    }

    public void setProcess(int process) {
      this.process = process;
    }

  }
}
