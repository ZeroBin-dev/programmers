package level3;

import java.util.Arrays;

/**
 * 제목 : 정수 삼각형
 * 설명 : 위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다.
 * 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.
 * 삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.
 */

public class L43105 {

  public static void main(String[] args) {
    System.out.println(
      new L43105().solution(
        new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}
      )
    );
  }

  public int solution(int[][] triangle) {
    int height = triangle.length;

    // DP 배열 초기화
    int[][] dp = new int[height][];
    for (int i = 0; i < height; i++) {
      dp[i] = new int[i + 1];
    }

    // 맨 위의 숫자부터 시작하여 아래층으로 내려가면서 최적의 경로를 구함
    dp[0][0] = triangle[0][0];
    for (int i = 1; i < height; i++) {
      for (int j = 0; j <= i; j++) {
        // 현재 위치에서 이동 가능한 다음 위치의 값 중 최대값을 현재 위치의 값과 더하여 최대 합을 갱신
        if (j == 0) {
          dp[i][j] = dp[i - 1][j] + triangle[i][j];
        } else if (j == i) {
          dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
        }
      }
    }


    return Arrays.stream(dp[height - 1]).max().orElse(0);
  }
}
