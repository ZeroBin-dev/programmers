package level1;

/**
 * 제목 : 소수 찾기
 * 설명 : 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 * <p>
 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 * (1은 소수가 아닙니다.)
 * <p>
 * 제한 조건
 * n은 2이상 1000000이하의 자연수입니다.
 */

public class L12921 {

  public static void main(String[] args) {
    System.out.println(
      new L12921().solution(
        10
      )
    );
  }

  public int solution(int n) {
    int answer = 0;
    for(int i=1;i<=n;i++){
      if(isSosu(i)) answer++;
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

