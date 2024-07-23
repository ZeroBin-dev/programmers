package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Level 0
 * 어려운문제
 */
public class Level0_diff {

  /**
   * No : 1
   * title : 옹알이 (1)
   * desc : 머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다.
   * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다.
   * 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
   */
  public static int solution1(String[] babbling) {
    String[] myList = {"aya", "ye", "woo", "ma"};
    return (int) Arrays.stream(babbling)
      .filter(s -> {
        for (String word : myList) {
          s = s.replace(word, " "); // 같은 단어가 있으면 공백으로 치환
        }
        return s.replace(" ", "").isEmpty(); // 공백을 전부 지웠을때 문자열이 비어있으면 발음할 수 있음
      })
      .count();
  }

  /**
   * No : 2
   * title : 정수를 나선형으로 배치하기
   * desc : 양의 정수 n이 매개변수로 주어집니다. n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터 시계방향
   * 나선형으로 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.
   */
  public static int[][] solution2(int n) {
    int[][] result = new int[n][n];
    int y = 0; // 위아래 좌표
    int x = 0; // 좌우 좌표
    int right = 0; // 오른쪽에 닿았을때
    int left = 0; // 왼쪽에 닿았을때
    int down = 0; // 아래쪽에 닿았을때
    int up = 1; // 위쪽에 닿았을때
    String direction = "R"; // 이동방향

    for (int i = 1; i <= n * n; i++) {

      if ("R".equals(direction)) {
        result[y][x] = i;
        if (x == (n - 1) - right) {
          direction = "D";
          right++;
          y++; // 오른쪽 벽에 부딪히면 아래로 이동
        } else {
          x++; // 오른쪽 이동
        }
      }

      // 아래쪽으로 이동하는 조건
      else if ("D".equals(direction)) {
        result[y][x] = i;
        if (y == (n - 1) - down) {
          direction = "L";
          down++;
          x--; // 아래쪽 벽에 부딪히면 왼쪽으로 이동
        } else {
          y++; // 아래로 이동
        }
      }

      // 왼쪽으로 이동하는 조건
      else if ("L".equals(direction)) {
        result[y][x] = i;
        if (x == left) {
          direction = "U";
          left++;
          y--; // 왼쪽벽에 부딪히면 위로 이동
        } else {
          x--; // 왼쪽으로 이동
        }
      }

      // 위쪽으로 이동하는 조건
      else if ("U".equals(direction)) {
        result[y][x] = i;
        if (y == up) {
          direction = "R";
          up++;
          x++; // 위쪽벽에 부딪히면 오른쪽으로 이동
        } else {
          y--; // 위로 이동
        }
      }
    }

    return result;
  }

  /**
   * No : 3
   * title : 평행
   * desc : 점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
   * [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
   * 주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.
   */
  public static int solution3(int[][] dots) {
    double line1 = Math.abs((double) (dots[1][1] - dots[0][1]) / (dots[1][0] - dots[0][0]));
    double line2 = Math.abs((double) (dots[3][1] - dots[2][1]) / (dots[3][0] - dots[2][0]));
    return line1 == line2 ? 1 : 0;
  }

  /**
   * No : 4
   * title : 겹치는 선분의 길이
   * desc : 선분 3개가 평행하게 놓여 있습니다. 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로
   * 들어있는 2차원 배열 lines가 매개변수로 주어질 때, 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.
   */
  public static int solution4(int[][] lines){
    int answer = 0;
    int t_max = 100;
    int t_min = -100;
    int a = 0; // 비교대상 앞
    int b = 1; // 비교대상 뒤
    for(int i=0;i<3;i++){
      if(b == 3){
        a = b-1;
        b = 0;
      }
      int max = lines[a][1] > lines[b][1] ? lines[b][1] : lines[a][1]; // max 중 최소
      int min = lines[a][0] > lines[b][0] ? lines[a][0] : lines[b][0]; // min 중 최대  m-n

      t_max = t_max > max ? max : t_max;
      t_min = t_min > min ? t_min : min;

      if(max>min){
        answer += max-min;
      }
      a++;
      b++;
    }

    if(t_max > t_min){
      answer -= (t_max-t_min)*2; // 셋다 겹치는곳을 찾음(이미 3번이 더해졌을테니 2번은 빼야됨)
    }

    return answer;
  }

  public static void main(String[] args) {
    // solution1
    System.out.println("solution1(옹알이 (1)) >>> [ 첫번째 : " + solution1(new String[]{"aya", "yee", "u", "maa", "wyeoo"}) +
      ", 두번째 : " + solution1(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}) + "]");

    // solution2
    System.out.println("solution2(정수를 나선형으로 배치하기) >>> [");
    Arrays.stream(solution2(5))
      .forEach(row -> {
        Arrays.stream(row)
          .forEach(element -> System.out.print(element + " "));
        System.out.println();
      });
    System.out.println("]");

    // solution3
    System.out.println("solution3(평행) >>> [ 첫번째 : " + solution3(new int[][]{{3, 5}, {4, 4}, {8, 9}, {6, 11}}) +
      ", 두번째 : " + solution3(new int[][]{{3, 5}, {4, 1}, {2, 4}, {5, 10}}) + "]");

    // solution4
    System.out.println("solution4(겹치는 선분의 길이) >>> [ 첫번째 : " + solution4(new int[][]{{0, 1}, {2, 5}, {3, 9}}) +
      ", 두번째 : " + solution4(new int[][]{{-1, 1}, {1, 3}, {3, 9}}) +
      ", 세번째 : " + solution4(new int[][]{{0, 5}, {3, 9}, {1, 10}}) + "]");

    // solution5
    IntStream.rangeClosed(0, 10)
      .filter(i -> i%2 == 0)
      .sum();
  }

}
