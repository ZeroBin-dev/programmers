package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 제목 : 수식 복원하기
 * 설명 : 당신은 덧셈 혹은 뺄셈 수식이 여러 개 적힌 고대 문명의 유물을 찾았습니다. 이 수식들을 관찰하던 당신은 이 문명이 사용하던 진법 체계가 10진법이 아니라는 것을 알아냈습니다. (2 ~ 9진법 중 하나입니다.)
 * <p>
 * 수식들 중 몇 개의 수식은 결괏값이 지워져 있으며, 당신은 이 문명이 사용하던 진법에 맞도록 지워진 결괏값을 채워 넣으려 합니다.
 */

public class L340210 {

  public static void main(String[] args) {
    System.out.println(
            new L340210().solution(
                    new String[]{"2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "5 - 5 = X"}
            )
    );
  }

  public String[] solution(String[] expressions) {
    List<Integer> list = new ArrayList<>();
    for (int i = 2; i <= 9; i++) {
      list.add(i);
    }

    List<BinaryData> problemList = new ArrayList<>();

    // 진법 체크
    for (String expression : expressions) {
      String[] ex = expression.split(" ");
      BinaryData binaryData = new BinaryData();
      binaryData.a = Integer.parseInt(ex[0]);
      binaryData.op = ex[1];
      binaryData.b = Integer.parseInt(ex[2]);
      binaryData.result = ex[4];

      if ("X".equals(binaryData.result)) {
        problemList.add(binaryData);
      } else {
        checkBinary(binaryData, list);
      }
    }

    String[] answer = new String[problemList.size()];

    // 진법 거르기
    String str = problemList.stream().map(i -> String.valueOf(i.a)+String.valueOf(i.b)).collect(Collectors.joining());
    Integer[] temp = Arrays.copyOfRange(list.toArray(Integer[]::new), 0, list.size());
    for(int i : temp){
      if(str.chars().map(Character::getNumericValue).anyMatch(digit -> digit >= i)){
        list.remove(list.indexOf(i));
      }
    }

    for (int i = 0; i < problemList.size(); i++) {
      BinaryData binaryData = problemList.get(i);

      String result = "-1"; // 결과 값이 음수가 되진 않으므로
      for (Integer j : list) {
        String c = calc(binaryData, j);
        if ("-1".equals(result)) {
          result = c;
        } else {
          if (!c.equals(result)) {
            result = "?";
            break;
          }
        }
      }
      binaryData.result = result;
      answer[i] = binaryData.print();
    }

    return answer;
  }

  // 2~9 진법체크
  public void checkBinary(BinaryData binaryData, List<Integer> list) {
    String str = String.valueOf(binaryData.a) + String.valueOf(binaryData.b) + binaryData.result;
    Integer[] temp = Arrays.copyOfRange(list.toArray(Integer[]::new), 0, list.size());

    for (int i : temp) {
      // 체크
      int finalI = i;
      if (str.chars().map(Character::getNumericValue).anyMatch(digit -> digit >= finalI)
              || !binaryData.result.equals(calc(binaryData, finalI))) {
        list.remove(list.indexOf(finalI));
      }
    }
  }

  public String calc(BinaryData binaryData, int binary) {
    int dec1 = Integer.parseInt(String.valueOf(binaryData.a), binary);
    int dec2 = Integer.parseInt(String.valueOf(binaryData.b), binary);
    return "+".equals(binaryData.op) ? Integer.toString(dec1 + dec2, binary) : Integer.toString(dec1 - dec2, binary);
  }

  public static class BinaryData {
    public int a;
    public int b;
    public String op;
    public String result;

    public String print() {
      return String.valueOf(a) + " " + op + " " + String.valueOf(b) + " = " + result;
    }
  }

}
