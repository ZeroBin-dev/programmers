package level2;

import java.util.ArrayList;
import java.util.List;

/**
 * 제목 : 하노이의 탑
 * 설명 : 하노이 탑(Tower of Hanoi)은 퍼즐의 일종입니다. 세 개의 기둥과 이 기동에 꽂을 수 있는 크기가 다양한 원판들이 있고,
 * 퍼즐을 시작하기 전에는 한 기둥에 원판들이 작은 것이 위에 있도록 순서대로 쌓여 있습니다. 게임의 목적은 다음 두 가지 조건을 만족시키면서,
 * 한 기둥에 꽂힌 원판들을 그 순서 그대로 다른 기둥으로 옮겨서 다시 쌓는 것입니다.
 * <p>
 * 한 번에 하나의 원판만 옮길 수 있습니다.
 * 큰 원판이 작은 원판 위에 있어서는 안됩니다.
 * 하노이 탑의 세 개의 기둥을 왼쪽 부터 1번, 2번, 3번이라고 하겠습니다. 1번에는 n개의 원판이 있고 이 n개의 원판을 3번 원판으로 최소 횟수로 옮기려고 합니다.
 * <p>
 * 1번 기둥에 있는 원판의 개수 n이 매개변수로 주어질 때, n개의 원판을 3번 원판으로 최소로 옮기는 방법을 return하는 solution를 완성해주세요.
 * <p>
 * 제한사항
 * n은 15이하의 자연수 입니다.
 * <p>
 * [일반화]
 * 1번의 n개 중 n-1개를 2번으로 옮긴다.
 * 1번의 가장 큰 n을 3번으로 옮긴다.
 * 2번의 n-1개를 3번으로 옮긴다.
 */
public class L12946 {

  private static List<int[]> list = new ArrayList<>();

  public static void main(String[] args) {
    System.out.println(
      new L12946().solution(
        4
      )
    );
  }

  public int[][] solution(int n) {
    dfs(n, 1, 3, 2);
    int[][] answer = new int[list.size()][2];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }

  private static void dfs(int n, int start, int end, int mid) {
    if (n == 1) {
      list.add(new int[]{start, end});
      return;
    }

    dfs(n - 1, start, mid, end); // 1번 -> 2번
    list.add(new int[]{start, end}); // 가장 큰 원판을 1번 -> 3번
    dfs(n - 1, mid, end, start); // 2번 -> 3번
  }


}
