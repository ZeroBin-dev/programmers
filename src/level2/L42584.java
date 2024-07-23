package level2;

/**
 * 제목 : 주식가격
 * 설명 : 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
 * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 */
public class L42584 {

  public static void main(String[] args) {
    System.out.println(
      new L42584().solution(
        new int[]{1, 2, 3, 2, 3}
      )
    );
  }

  public int[] solution(int[] prices) {
    int[] result = new int[prices.length];

    for(int i = 0 ; i < prices.length-1 ; i++){
      int count = 0;
      for(int j = i+1 ; j < prices.length ; j++){
        count++;
        if(prices[i] > prices[j]){
          break;
        }
      }
      result[i] = count;
    }

    return result;
  }


}
