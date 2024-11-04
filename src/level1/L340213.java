package level1;

/**
 * 제목 : 동영상 재생기
 * 설명 : 당신은 동영상 재생기를 만들고 있습니다. 당신의 동영상 재생기는 10초 전으로 이동, 10초 후로 이동, 오프닝 건너뛰기 3가지 기능을 지원합니다. 각 기능이 수행하는 작업은 다음과 같습니다.
 * <p>
 * 10초 전으로 이동: 사용자가 "prev" 명령을 입력할 경우 동영상의 재생 위치를 현재 위치에서 10초 전으로 이동합니다. 현재 위치가 10초 미만인 경우 영상의 처음 위치로 이동합니다. 영상의 처음 위치는 0분 0초입니다.
 * 10초 후로 이동: 사용자가 "next" 명령을 입력할 경우 동영상의 재생 위치를 현재 위치에서 10초 후로 이동합니다. 동영상의 남은 시간이 10초 미만일 경우 영상의 마지막 위치로 이동합니다. 영상의 마지막 위치는 동영상의 길이와 같습니다.
 * 오프닝 건너뛰기: 현재 재생 위치가 오프닝 구간(op_start ≤ 현재 재생 위치 ≤ op_end)인 경우 자동으로 오프닝이 끝나는 위치로 이동합니다.
 * 동영상의 길이를 나타내는 문자열 video_len, 기능이 수행되기 직전의 재생위치를 나타내는 문자열 pos, 오프닝 시작 시각을 나타내는 문자열 op_start, 오프닝이 끝나는 시각을 나타내는 문자열 op_end, 사용자의 입력을 나타내는 1차원 문자열 배열 commands가 매개변수로 주어집니다. 이때 사용자의 입력이 모두 끝난 후 동영상의 위치를 "mm:ss" 형식으로 return 하도록 solution 함수를 완성해 주세요.
 *
 *
 * 제한사항
 * video_len의 길이 = pos의 길이 = op_start의 길이 = op_end의 길이 = 5
 * video_len, pos, op_start, op_end는 "mm:ss" 형식으로 mm분 ss초를 나타냅니다.
 * 0 ≤ mm ≤ 59
 * 0 ≤ ss ≤ 59
 * 분, 초가 한 자리일 경우 0을 붙여 두 자리로 나타냅니다.
 * 비디오의 현재 위치 혹은 오프닝이 끝나는 시각이 동영상의 범위 밖인 경우는 주어지지 않습니다.
 * 오프닝이 시작하는 시각은 항상 오프닝이 끝나는 시각보다 전입니다.
 * 1 ≤ commands의 길이 ≤ 100
 * commands의 원소는 "prev" 혹은 "next"입니다.
 * "prev"는 10초 전으로 이동하는 명령입니다.
 * "next"는 10초 후로 이동하는 명령입니다.
 */

public class L340213 {

  public static void main(String[] args) {
    System.out.println(
      new L340213().solution(
        "02:00", "00:55", "00:55", "01:00", new String[]{"next"}
      )
    );
  }

  public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
    long l_video = changeSeconds(video_len); // 비디오 길이
    long l_pos = changeSeconds(pos); // 현재위치
    long l_start = changeSeconds(op_start); // 오프닝 시작
    long l_end = changeSeconds(op_end); // 오프닝 종료

    for (String command : commands) {
      // 이동전 오프닝에 걸쳤을때
      l_pos = checkOp(l_pos, l_start, l_end);

      // prev
      if (command.equals("prev")) {
        l_pos -= 10;
        l_pos = Math.max(0, l_pos);
      }

      // next
      else {
        l_pos += 10;
        l_pos = Math.min(l_pos, l_video);
      }

      // 이동후 오프닝에 걸쳤을때
      l_pos = checkOp(l_pos, l_start, l_end);
    }

    return changeMinute(l_pos);
  }

  private long changeSeconds(String time) {
    String[] temp = time.split(":");
    return Long.parseLong(temp[0]) * 60 + Long.parseLong(temp[1]);
  }

  private String changeMinute(long time) {
    String m = (time / 60 < 10) ? "0" + time / 60 : time / 60 + "";
    String s = (time % 60 < 10) ? "0" + time % 60 : time % 60 + "";
    return m + ":" + s;
  }

  private long checkOp(long time, long op_s, long op_e){
    return (time >= op_s && time <= op_e) ? op_e : time;
  }
}
