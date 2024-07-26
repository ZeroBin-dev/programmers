package level2;

import java.util.Arrays;

/**
 * 제목 : H-Index
 * 설명 : H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 */
public class L42747 {

  public static void main(String[] args) {
    System.out.println(
      new L42747().solution(
        new int[]{300, 0, 600, 100, 500}
      )
    );

    System.out.println(
      new L42747().solution_other(
        new int[]{3, 0, 6, 1, 5}
      )
    );
  }

  public int solution(int[] citations) {
    Arrays.sort(citations);

    int left = 0;
    int right = citations.length;
    int len = citations.length;

    while (left < right) {
      int mid = (left + right) / 2;
      if (citations[mid] >= len - mid) {
        right = mid; // 여기 보단 왼쪽에 있음
      } else {
        left = mid + 1; // 더 큰 값을 찾아야함
      }
    }

    return len - left;
  }

  // 다른사람풀이
  // 원소 값은 점점 감소하고, 원소 값 이상인 것의 개수는 점점 감소하므로... 이 두 값의 최소값의 변화가 증가하다가 감소하는 지점을 찾으면
  public int solution_other(int[] citations) {
    Arrays.sort(citations);

    int max = 0;
    for (int i = citations.length - 1; i > -1; i--) {
      int min = (int) Math.min(citations[i], citations.length - i);
      if (max < min) max = min;
    }

    return max;
  }


}
