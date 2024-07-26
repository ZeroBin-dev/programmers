package level2;

import java.util.Arrays;

/**
 * 제목 : N개의 최소공배수
 * 설명 : 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
 * 예를 들어 2와 7의 최소공배수는 14가 됩니다.
 * 의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
 * n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 *
 * 제한 사항
 * arr은 길이 1이상, 15이하인 배열입니다.
 * arr의 원소는 100 이하인 자연수입니다.
 */
public class L12953 {

  public static void main(String[] args) {
    System.out.println(
      new L12953().solution(
        new int[]{12, 32, 45, 67, 72} // 168
        // new int[]{1,2,3} // 6
      )
    );
  }

  public int solution(int[] arr) {
    Arrays.sort(arr);
    int max = arr[arr.length-1];

    for(int i = max;i<Integer.MAX_VALUE;i++){
      boolean flag = true;
      for(int j=0;j<arr.length;j++){
        if(i % arr[j] != 0){
          flag = false;
          break;
        }
      }
      if(flag) return i;
    }

    return -1;
  }
}