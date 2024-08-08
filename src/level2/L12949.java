package level2;

/**
 * 제목 : 행렬의 곱셈
 * 설명 : 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
 *
 * 제한 조건
 * 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
 * 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
 * 곱할 수 있는 배열만 주어집니다.
 *
 */
public class L12949 {

  public static void main(String[] args) {
    System.out.println(
      new L12949().solution(
        new int[][]{{1, 4}, {3, 2}, {4, 1}},
        new int[][]{{3, 3}, {3, 3}}
      )
    );
  }

  public int[][] solution(int[][] arr1, int[][] arr2) {
    int m = arr1.length;
    int n = arr2[0].length;

    int[][] answer = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < arr1[0].length; k++) {
          answer[i][j] += arr1[i][k] * arr2[k][j];
        }
      }
    }

    return answer;
  }
}
