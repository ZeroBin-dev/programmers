package level1;

/**
 * 제목 : 공원산책
 * 설명 : 지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 로봇 강아지가 산책을 하려합니다. 산책은 로봇 강아지에 미리 입력된 명령에 따라 진행하며, 명령은 다음과 같은 형식으로 주어집니다.
 * <p>
 * ["방향 거리", "방향 거리" … ]
 * 예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다. 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.
 * <p>
 * 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
 * 주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
 * <p>
 * 위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.
 * 공원의 가로 길이가 W, 세로 길이가 H라고 할 때, 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 입니다.
 */

public class L172928 {

  public static void main(String[] args) {
    System.out.println(
      new L172928().solution(
        //new String[]{"SOO","OOO","OOO"}, new String[]{"E 2","S 2","W 1"} // 2,1
        //new String[]{"OSO","OOO","OXO","OOO"}, new String[]{"E 2","S 3","W 1"}
        //new String[]{"OSO","OOO","OXO","OOO"}, new String[]{"E 2","S 3","W 1"}
    new String[]{"OXO", "XSX", "OXO"}, new String[]{"S 1", "E 1", "W 1", "N 1"} // 2,1
      )
    );
  }

  public int[] solution(String[] park, String[] routes) {
    int xLen = park[0].length() - 1; // 넓이
    int yLen = park.length - 1; // 높이

    int[] cur = new int[2]; // 시작점
    for (int i = 0; i < park.length; i++) {
      for (int j = 0; j < park[i].length(); j++) {
        char ch = park[i].charAt(j);
        if (ch == 'S') {
          cur[0] = i;
          cur[1] = j;
          break;
        }
      }
    }

    for (int i = 0; i < routes.length; i++) {
      String direction = routes[i].split(" ")[0];
      int move = Integer.parseInt(routes[i].split(" ")[1]);
      int x = cur[0];
      int y = cur[1];
      if (move == 0) continue;

      boolean canMove = true;

      switch (direction) {
        case "E": // 오른쪽 이동
          if (y + move > xLen) {
            canMove = false;
          } else {
            for (int k = y + 1; k <= y + move; k++) {
              if (park[x].charAt(k) == 'X') {
                canMove = false;
                break;
              }
            }
          }
          if (canMove) y += move;
          break;
        case "W": // 왼쪽으로 이동
          if (y - move < 0) {
            canMove = false;
          } else {
            for (int k = y - 1; k >= y - move; k--) {
              if (park[x].charAt(k) == 'X') {
                canMove = false;
                break;
              }
            }
          }
          if (canMove) y -= move;
          break;
        case "S": // 아래쪽으로 이동
          if (x + move > yLen) {
            canMove = false;
          } else {
            for (int k = x + 1; k <= x + move; k++) {
              if (park[k].charAt(y) == 'X') {
                canMove = false;
                break;
              }
            }
          }
          if (canMove) x += move;
          break;
        case "N": // 위쪽으로 이동
          if (x - move < 0) {
            canMove = false;
          } else {
            for (int k = x - 1; k >= x - move; k--) {
              if (park[k].charAt(y) == 'X') {
                canMove = false;
                break;
              }
            }
          }
          if (canMove) x -= move;
          break;
      }

      cur[0] = x;
      cur[1] = y;
    }

    return cur;
  }
}
