package level2;

/**
 * 제목 : 모음 사전
 * 설명 : 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다.
 * 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
 * 단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * word의 길이는 1 이상 5 이하입니다.
 * word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
 *
 */
public class L84512 {

  public static void main(String[] args) {
    System.out.println(
      new L84512().solution(
        "AAAAE" // 6
        //"AAAE" // 10
        //"I" // 1563
        //"EIO" // 1189
      )
    );
  }

  public int solution(String word) {
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    int len = vowels.length;

    int[] weights = new int[len];

    for(int i = 0;i<len;i++){
      for(int j = 0;j<len-i;j++){
        weights[i] += (int)Math.pow(len, j);
      }
    }

    int result = 0;

    for (int i = 0; i < word.length(); i++) {
      int index = new String(vowels).indexOf(word.charAt(i));
      result += index * weights[i] + 1;
    }
    return result;
  }
}
