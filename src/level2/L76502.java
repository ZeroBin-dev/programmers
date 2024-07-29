package level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 제목 : 괄호 회전하기
 * 설명 : 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
 * <p>
 * (), [], {} 는 모두 올바른 괄호 문자열입니다.
 * 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
 * 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
 * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.
 * 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사항
 * s의 길이는 1 이상 1,000 이하입니다.
 */
public class L76502 {

  public static void main(String[] args) {
    System.out.println(
      new L76502().solution(
        "(){{" // 3
      )
    );
  }

  public int solution(String s) {
    StringBuilder sb = new StringBuilder(s + s);
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
      boolean isPos = true;
      String str = sb.substring(i, i + s.length());
      Stack<Character> stack = new Stack<>();

      for (char c : str.toCharArray()) {

        // 여는괄호
        if (c == '(' || c == '{' || c == '[') {
          stack.push(c);
          isPos = false;
        } else {
          if (stack.isEmpty()) {
            isPos = false;
            break;
          }

          char top = stack.pop();

          if ((c == ')' && top != '(') ||
            (c == '}' && top != '{') ||
            (c == ']' && top != '[')) {
            isPos = false;
            break;
          }

          isPos = true;
        }

      }

      if (isPos && stack.isEmpty()) count++;
    }

    return count;
  }
}
