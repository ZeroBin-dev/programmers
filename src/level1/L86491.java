package level1;

/**
 * 제목 : 최소직사각형
 * 설명 : 명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다. 이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.
 * <p>
 * 아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.
 */

public class L86491 {

  public static void main(String[] args) {
    System.out.println(
      new L86491().solution(
        new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}
      )
    );
  }

  public int solution(int[][] sizes) {
    int w = 0;
    int h = 0;

    for (int i = 0; i < sizes.length; i++) {
      int max = Math.max(sizes[i][0], sizes[i][1]);
      int min = Math.min(sizes[i][0], sizes[i][1]);

      if (max > w) {
        w = max;
      }

      if (min > h) {
        h = min;
      }
    }

    return w * h;
  }
}
