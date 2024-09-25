package level2;

import java.util.HashSet;
import java.util.Set;

/**
 * 제목 : 방문 길이
 * 설명 : 게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.
 * U: 위쪽으로 한 칸 가기
 * D: 아래쪽으로 한 칸 가기
 * R: 오른쪽으로 한 칸 가기
 * L: 왼쪽으로 한 칸 가기
 * 캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.
 */
public class L49994 {

  public static void main(String[] args) {
    System.out.println(
      new L49994().solution(
        "ULURRDLLU"
      )
    );
  }

  public int solution(String dirs) {
    int answer = 0;
    int x = 5;
    int y = 5;

    // 위, 아래, 오른, 왼
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    char[] directions = {'U', 'D', 'R', 'L'};

    Set<String> visited = new HashSet<>();

    for (char c : dirs.toCharArray()) {
      int index = -1;



      // 방향 인덱스 찾기
      for (int i = 0; i < directions.length; i++) {
        if (directions[i] == c) {
          index = i;
          break;
        }
      }

      // 이동할 좌표계산
      int nx = x + dx[index];
      int ny = y + dy[index];

      // 범위 확인
      if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;

      // 경로 방문한적이 있는지 체크
      String path1 = x+","+y+"-"+nx+","+ny;
      String path2 = nx+","+ny+"-"+x+","+y;

      if(!visited.contains(path1) && !visited.contains(path2)){
        visited.add(path1);
        visited.add(path2);
        answer++;
      }

      // 위치 갱신
      x = nx;
      y = ny;
    }

    return answer;
  }
}
