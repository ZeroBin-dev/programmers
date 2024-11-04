package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 제목 : 충돌위험 찾기
 * 설명 : 어떤 물류 센터는 로봇을 이용한 자동 운송 시스템을 운영합니다. 운송 시스템이 작동하는 규칙은 다음과 같습니다.
 * <p>
 * 물류 센터에는 (r, c)와 같이 2차원 좌표로 나타낼 수 있는 n개의 포인트가 존재합니다.
 * 각 포인트는 1~n까지의 서로 다른 번호를 가집니다.
 * 로봇마다 정해진 운송 경로가 존재합니다.
 * <p>
 * 운송 경로는 m개의 포인트로 구성되고 로봇은 첫 포인트에서 시작해 할당된 포인트를 순서대로 방문합니다.
 * 운송 시스템에 사용되는 로봇은 x대이고, 모든 로봇은 0초에 동시에 출발합니다.
 * 로봇은 1초마다 r 좌표와 c 좌표 중 하나가 1만큼 감소하거나 증가한 좌표로 이동할 수 있습니다.
 * <p>
 * 다음 포인트로 이동할 때는 항상 최단 경로로 이동하며 최단 경로가 여러 가지일 경우, r 좌표가 변하는 이동을 c 좌표가 변하는 이동보다 먼저 합니다.
 * 마지막 포인트에 도착한 로봇은 운송을 마치고 물류 센터를 벗어납니다.
 * 로봇이 물류 센터를 벗어나는 경로는 고려하지 않습니다.
 * <p>
 * 이동 중 같은 좌표에 로봇이 2대 이상 모인다면 충돌할 가능성이 있는 위험 상황으로 판단합니다.
 * 관리자인 당신은 현재 설정대로 로봇이 움직일 때 위험한 상황이 총 몇 번 일어나는지 알고 싶습니다.
 * 만약 어떤 시간에 여러 좌표에서 위험 상황이 발생한다면 그 횟수를 모두 더합니다.
 * <p>
 * 운송 포인트 n개의 좌표를 담은 2차원 정수 배열 points와 로봇 x대의 운송 경로를 담은 2차원 정수 배열 routes가 매개변수로 주어집니다.
 * 이때 모든 로봇이 운송을 마칠 때까지 발생하는 위험한 상황의 횟수를 return 하도록 solution 함수를 완성해 주세요.
 * <p>
 * 제한사항
 * 2 ≤ points의 길이 = n ≤ 100
 * points[i]는 i + 1번 포인트의 [r 좌표, c 좌표]를 나타내는 길이가 2인 정수 배열입니다.
 * 1 ≤ r ≤ 100
 * 1 ≤ c ≤ 100
 * 같은 좌표에 여러 포인트가 존재하는 입력은 주어지지 않습니다.
 * 2 ≤ routes의 길이 = 로봇의 수 = x ≤ 100
 * 2 ≤ routes[i]의 길이 = m ≤ 100
 * routes[i]는 i + 1번째 로봇의 운송경로를 나타냅니다. routes[i]의 길이는 모두 같습니다.
 * routes[i][j]는 i + 1번째 로봇이 j + 1번째로 방문하는 포인트 번호를 나타냅니다.
 * 같은 포인트를 연속으로 방문하는 입력은 주어지지 않습니다.
 * 1 ≤ routes[i][j] ≤ n
 */
public class L340211 {

  public static void main(String[] args) {
    // case1
    System.out.println(
      new L340211().solution(
        new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}},
        new int[][]{{4, 2}, {1, 3}, {2, 4}}
      )
    );
    // case2
    System.out.println(
      new L340211().solution(
        new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}},
        new int[][]{{4, 2}, {1, 3}, {4, 2}, {4, 3}}
      )
    );
    // case3
    System.out.println(
      new L340211().solution(
        new int[][]{{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}},
        new int[][]{{2, 3, 4, 5}, {1, 3, 4, 5}}
      )
    );

  }

  public int solution(int[][] points, int[][] routes) {
    int answer = 0;
    List<MyRobot> robotList = new ArrayList<>();

    // 로봇 객체 생성
    for (int i = 0; i < routes.length; i++) {
      MyRobot myRobot = new MyRobot();
      myRobot.setCur(new int[]{points[routes[i][0] - 1][0]-1, points[routes[i][0] - 1][1]}); // 로봇의 초기위치 지정(0초일때도 체크하기위해 r 에 -1로 입력)
      List<int[]> list = new ArrayList<>();
      for (int j = 0; j < routes[i].length; j++) {
        int[] pos = new int[]{
          points[routes[i][j] - 1][0], points[routes[i][j] - 1][1]
        };
        list.add(pos);
      }
      myRobot.setList(list);
      robotList.add(myRobot);
    }

    // 각 로봇이 1초마다 움직일때 tempList 에 담고 그룹핑
    // 모든 로봇이 다 도착했는지 체크
    while (!isAllArrive(robotList)) {
      List<String> list = new ArrayList<>();
      for (MyRobot myRobot : robotList) {
        // 아직 도착하지 못한 로봇들만 체크
        if (!myRobot.isArrive()) {

          // 이동 및 도착 체크
          move(myRobot, list);
        }
      }
      // 리스트에 입력 및 경로 겹침체크
      answer += check(list);
    }

    return answer;
  }

  public void move(MyRobot myRobot, List<String> list) {
    int[] cur = myRobot.getCur();
    int[] next = myRobot.getList().get(myRobot.getIndex());

    // 상하 이동
    if (cur[0] != next[0]) {
      cur[0] = cur[0] > next[0] ? cur[0] - 1 : cur[0] + 1;
    }

    // 좌우 이동
    else if (cur[1] != next[1]) {
      cur[1] = cur[1] > next[1] ? cur[1] - 1 : cur[1] + 1;
    }

    // 현재 위치 갱신 및 list 에 입력
    myRobot.setCur(cur);
    list.add(cur[0] + "," + cur[1]);

    // 도착체크
    if (cur[0] == next[0] && cur[1] == next[1]) {

      // 최종도착 체크
      if (myRobot.getIndex() == myRobot.getList().size() - 1) {
        myRobot.setArrive(true);
      } else {
        // 다음 인덱스
        myRobot.setIndex(myRobot.getIndex() + 1);
      }
    }
  }

  public int check(List<String> list){
    return (int)list.stream()
      .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
      .entrySet().stream()
      .filter(entry -> entry.getValue() >= 2)
      .count();
  }

  /**
   * 모든 로봇이 다 도착했는지 체크
   */
  public boolean isAllArrive(List<MyRobot> robotList) {
    boolean isArrive = true;
    for (MyRobot myRobot : robotList) {
      if (!myRobot.isArrive()) return false;
    }
    return isArrive;
  }

  class MyRobot {
    private int[] cur; // 현재위치
    private List<int[]> list; // 목적지 리스트
    private int index = 0; // 현재 목적지
    private boolean arrive = false; // 최종도착여부

    public int[] getCur() {
      return cur;
    }

    public void setCur(int[] cur) {
      this.cur = cur;
    }

    public List<int[]> getList() {
      return list;
    }

    public void setList(List<int[]> list) {
      this.list = list;
    }

    public int getIndex() {
      return index;
    }

    public void setIndex(int index) {
      this.index = index;
    }

    public boolean isArrive() {
      return arrive;
    }

    public void setArrive(boolean arrive) {
      this.arrive = arrive;
    }
  }

}
