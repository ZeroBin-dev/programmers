package level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 제목 : 베스트앨범
 * 설명 : 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * <p>
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 */

public class L42579 {

  public static void main(String[] args) {
    System.out.println(
      new L42579().solution(
        new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}
      )
    );
  }

  public int[] solution(String[] genres, int[] plays) {
    // 장르 순서 정렬
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < genres.length; i++) {
      int p = map.getOrDefault(genres[i], 0);
      map.put(genres[i], p + plays[i]);
    }

    ArrayList<String> genresList = map.entrySet()
      .stream()
      .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
      .map(Map.Entry::getKey)
      .collect(Collectors.toCollection(ArrayList::new));

    ArrayList<Integer> result = new ArrayList<>();

    // 상위2개의 아이디 저장
    for (int i = 0; i < genresList.size(); i++) {
      String gen = genresList.get(i);
      ArrayList<String> rank = new ArrayList<>();
      for (int j = 0; j < genres.length; j++) {
        if (gen.equals(genres[j])) {
          rank.add(plays[j] + "," + j);
        }
      }
      ArrayList<Integer> rankRe = rank.stream()
        .sorted((a, b) -> Integer.compare(
            Integer.parseInt(b.split(",")[0]),
            Integer.parseInt(a.split(",")[0])
          )
        ).map(k -> Integer.parseInt(k.split(",")[1]))
        .collect(Collectors.toCollection(ArrayList::new));

      result.add(rankRe.get(0));
      if (rankRe.size() > 1) {
        result.add(rankRe.get(1));
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}
