package level4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 제목 : 도둑질
 * 설명 : 도둑이 어느 마을을 털 계획을 하고 있습니다.
 * 이 마을의 모든 집들은 아래 그림과 같이 동그랗게 배치되어 있습니다.
 * 각 집들은 서로 인접한 집들과 방범장치가 연결되어 있기 때문에 인접한 두 집을 털면 경보가 울립니다.
 *
 * 각 집에 있는 돈이 담긴 배열 money가 주어질 때, 도둑이 훔칠 수 있는 돈의 최댓값을 return 하도록 solution 함수를 작성하세요.
 *
 * 제한사항
 * 이 마을에 있는 집은 3개 이상 1,000,000개 이하입니다.
 * money 배열의 각 원소는 0 이상 1,000 이하인 정수입니다.
 */

public class L42897 {

  public static void main(String[] args) {
    System.out.println(
      new L42897().solution(
        new int[]{1,2,3,1}
      )
    );
  }

  public int solution(int[] money) {
    int answer = 0;
    return answer;
  }
}
