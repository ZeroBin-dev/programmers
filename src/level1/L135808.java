package level1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 제목 : 과일장수
 * 설명 : 과일 장수가 사과 상자를 포장하고 있습니다. 사과는 상태에 따라 1점부터 k점까지의 점수로 분류하며, k점이 최상품의 사과이고 1점이 최하품의 사과입니다. 사과 한 상자의 가격은 다음과 같이 결정됩니다.
 *
 * 한 상자에 사과를 m개씩 담아 포장합니다.
 * 상자에 담긴 사과 중 가장 낮은 점수가 p (1 ≤ p ≤ k)점인 경우, 사과 한 상자의 가격은 p * m 입니다.
 * 과일 장수가 가능한 많은 사과를 팔았을 때, 얻을 수 있는 최대 이익을 계산하고자 합니다.(사과는 상자 단위로만 판매하며, 남는 사과는 버립니다)
 *
 * 예를 들어, k = 3, m = 4, 사과 7개의 점수가 [1, 2, 3, 1, 2, 3, 1]이라면, 다음과 같이 [2, 3, 2, 3]으로 구성된 사과 상자 1개를 만들어 판매하여 최대 이익을 얻을 수 있습니다.
 *
 * (최저 사과 점수) x (한 상자에 담긴 사과 개수) x (상자의 개수) = 2 x 4 x 1 = 8
 * 사과의 최대 점수 k, 한 상자에 들어가는 사과의 수 m, 사과들의 점수 score가 주어졌을 때, 과일 장수가 얻을 수 있는 최대 이익을 return하는 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 3 ≤ k ≤ 9
 * 3 ≤ m ≤ 10
 * 7 ≤ score의 길이 ≤ 1,000,000
 * 1 ≤ score[i] ≤ k
 * 이익이 발생하지 않는 경우에는 0을 return 해주세요.
 */

public class L135808 {

  public static void main(String[] args) {
    System.out.println(
      new L135808().solution(
        4,3,new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}
      )
    );
  }

  public int solution(int k, int m, int[] score) {
    int[] arr = Arrays.stream(score).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
    int box = score.length/m; // 박스수

    int answer = 0;

    for(int i = 1;i<=box;i++){
      answer += arr[i*m-1] * m;

    }

    return answer;
  }

}

