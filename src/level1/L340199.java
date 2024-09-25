package level1;

/**
 * 제목 : 지폐 접기
 * 설명 : 민수는 다양한 지폐를 수집하는 취미를 가지고 있습니다. 지폐마다 크기가 달라 지갑에 넣으려면 여러 번 접어서 넣어야 합니다.
 * 예를 들어 지갑의 크기가 30 * 15이고 지폐의 크기가 26 * 17이라면 한번 반으로 접어 13 * 17 크기로 만든 뒤 90도 돌려서 지갑에 넣을 수 있습니다. 지폐를 접을 때는 다음과 같은 규칙을 지킵니다.
 * <p>
 * 지폐를 접을 때는 항상 길이가 긴 쪽을 반으로 접습니다.
 * 접기 전 길이가 홀수였다면 접은 후 소수점 이하는 버립니다.
 * 접힌 지폐를 그대로 또는 90도 돌려서 지갑에 넣을 수 있다면 그만 접습니다.
 * 지갑의 가로, 세로 크기를 담은 정수 리스트 wallet과 지폐의 가로, 세로 크기를 담은 정수 리스트 bill가 주어질 때, 지갑에 넣기 위해서 지폐를 최소 몇 번 접어야 하는지 return하도록 solution함수를 완성해 주세요.
 * <p>
 * 지폐를 지갑에 넣기 위해 접어야 하는 최소 횟수를 구하는 과정은 다음과 같습니다.
 * <p>
 * 1. 지폐를 접은 횟수를 저장할 정수 변수 answer를 만들고 0을 저장합니다.
 * 2. 반복문을 이용해 bill의 작은 값이 wallet의 작은 값 보다 크거나 bill의 큰 값이 wallet의 큰 값 보다 큰 동안 아래 과정을 반복합니다.
 * 2-1. bill[0]이 bill[1]보다 크다면
 * bill[0]을 2로 나누고 나머지는 버립니다.
 * 2-2. 그렇지 않다면
 * bill[1]을 2로 나누고 나머지는 버립니다.
 * 2-3. answer을 1 증가시킵니다.
 * 3. answer을 return합니다.
 */

public class L340199 {

  public static void main(String[] args) {
    System.out.println(
      new L340199().solution(
        new int[]{50, 50}, new int[]{100, 241}
      )
    );
  }

  public int solution(int[] wallet, int[] bill) {
    // 큰걸 항상 앞쪽 입력
    wallet = swap(wallet);
    bill = swap(bill);
    int answer = 0;

    while (bill[0] > wallet[0] || bill[1] > wallet[1]) {
      bill[0] = bill[0]/2;
      bill = swap(bill);
      answer++;
    }

    return answer;
  }


  private int[] swap(int[] bill) {
    int[] temp = new int[2];
    temp[0] = Math.max(bill[0], bill[1]);
    temp[1] = Math.min(bill[0], bill[1]);
    return temp;
  }

}