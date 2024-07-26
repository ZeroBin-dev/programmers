package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 제목 : 의상
 * 설명 : 코니는 매일 다른 옷을 조합하여 입는것을 좋아합니다.
 * <p>
 * 예를 들어 코니가 가진 옷이 아래와 같고, 오늘 코니가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야합니다.
 * <p>
 * 종류	이름
 * 얼굴	동그란 안경, 검정 선글라스
 * 상의	파란색 티셔츠
 * 하의	청바지
 * 겉옷	긴 코트
 * 코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다. 예를 들어 위 예시의 경우 동그란 안경과 검정 선글라스를 동시에 착용할 수는 없습니다.
 * 착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산합니다.
 * 코니는 하루에 최소 한 개의 의상은 입습니다.
 * 코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 */
public class L42578 {

  public static void main(String[] args) {
    System.out.println(
      new L42578().solution(
        new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}
      )
    );
  }

  public int solution(String[][] clothes) {
    int len = clothes.length;

    if (len == 1) return 1;

    Map<String, ArrayList<String>> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      ArrayList<String> list = map.get(clothes[i][1]);

      if (list == null || list.size() == 0) {
        list = new ArrayList<>();
      }
      list.add(clothes[i][0]);
      map.put(clothes[i][1], list);
    }

    int size = map.size();
    int answer = 0;

    // 전체가 다 다름
    if (len == size) {
      answer = (int) Math.pow(2, len) - 1;
    }

    // 전체가 다 같음
    else if (size == 1) {
      answer = len;
    }

    // 2개이상 겹친게 있음
    else {
      for (String s : map.keySet()) {
        answer = (answer == 0) ? map.get(s).size() + 1 : answer * (map.get(s).size() + 1);
      }
      answer = answer - 1;
    }

    return answer;
  }


}
