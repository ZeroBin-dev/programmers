package level2;

import java.util.HashSet;
import java.util.Set;

/**
 * 제목 : 연속 부분 수열 합의 개수
 * 설명 : 철호는 수열을 가지고 놀기 좋아합니다.
 * 어느 날 철호는 어떤 자연수로 이루어진 원형 수열의 연속하는 부분 수열의 합으로 만들 수 있는 수가 모두 몇 가지인지 알아보고 싶어졌습니다.
 * 원형 수열이란 일반적인 수열에서 처음과 끝이 연결된 형태의 수열을 말합니다.
 * 예를 들어 수열 [7, 9, 1, 1, 4] 로 원형 수열을 만들면 다음과 같습니다.
 */
public class L131701 {

  public static void main(String[] args) {
    System.out.println(
      new L131701().solution(
        new int[]{7, 9, 1, 1, 4} // 18
      )
    );
  }

  public int solution(int[] elements) {
    Set<Integer> set = new HashSet<>();

    for (int i = 1; i <= elements.length; i++) {
      for (int j = 0; j < elements.length; j++) {
        int total = 0;
        for (int k = j; k < j+i; k++) {
          total += elements[k%elements.length];
        }
        set.add(total);
      }

    }

    return set.size();
  }

  /**
   * public int solution(int[] elements) {
   *             Set<Integer> set = new HashSet<>();
   *             int[] dp = new int[elements.length];
   *             for(int len = 1;len <= elements.length; len++){
   *                 for(int i = 0;i<elements.length;i++){
   *                     dp[i] += elements[(len+i-1)%elements.length];
   *                     set.add(dp[i]);
   *                 }
   *             }
   *             return set.size();
   *         }
   */
}
