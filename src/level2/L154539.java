package level2;

import java.util.Stack;

/**
 * 제목 : 뒤에 있는 큰 수 찾기
 * 설명 : 정수로 이루어진 배열 numbers가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
 * 정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.
 */
public class L154539 {

  public static void main(String[] args) {
    System.out.println(
      new L154539().solution(
        new int[]{9, 1, 5, 3, 6, 2}
      )
    );
  }

  public int[] solution(int[] numbers) {
    int[] answer = new int[numbers.length];
    Stack<Integer> stack = new Stack<>();

    // 뒤에서부터 순회
    for(int i = numbers.length - 1 ; i>=0;i--){

      // 스택이 비어있지 않으면 현재값과 비교해 작은 애들은 전부 pop
      while (!stack.isEmpty() && stack.peek() <= numbers[i]){
        stack.pop();
      }

      // 스택이 비어있으면 -1, 아니면 peek를 저장
      answer[i] = stack.isEmpty() ? -1 : stack.peek();

      // 현재숫자 stack 에 입력
      stack.push(numbers[i]);
    }

    return answer;
  }

}
