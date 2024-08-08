package level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 제목 : 소수만들기
 * 설명 : 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때,
 * nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사항
 * nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
 * nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
 */

public class L12977 {

  public static void main(String[] args) {
    System.out.println(
      new L12977().solution(
        new int[]{13, 100, 900}
      )
    );
  }

  public int solution(int[] nums) {
    List<Integer> set = new ArrayList<>();
    int n = nums.length;

    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          set.add(nums[i] + nums[j] + nums[k]);
        }
      }
    }

    int answer = 0;

    for(int num : set){
        if(isSosu(num)) answer++;
    }

    return answer;
  }

  public static boolean isSosu(int num) {
    if (num <= 1) return false;
    if (num <= 3) return true;

    if (num % 2 == 0 || num % 3 == 0) return false;

    for (int i = 5; i * i <= num; i += 6) {
      if (num % i == 0 || num % (i + 2) == 0) {
        return false;
      }
    }

    return true;
  }

}

