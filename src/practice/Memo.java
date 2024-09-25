package practice;

public class Memo {

  public static void main(String[] args) {
    new Memo().solution(
      "GO"
    );

  }

  /**
   * 소문자 l을 대문자 I로 변경합니다.
   * 소문자 w를 두 개의 소문자 v, 즉 vv로 변경합니다.
   * 대문자 W를 두 개의 대문자 V, 즉 VV로 변경합니다.
   * 대문자 O를 숫자 0으로 변경합니다.
   * 수정된 닉네임의 길이가 4 미만일 경우 뒤에 소문자 o를 길이가 4가 될때까지 이어붙입니다.
   * 수정된 닉네임의 길이가 8보다 클 경우 8번째 문자까지만 사용합니다.
   * */
  public String solution(String nickname) {
    String answer = "";
    for(int i=0; i<nickname.length(); i++){
      if(nickname.charAt(i) == 'l'){
        answer += "I";
      }
      else if(nickname.charAt(i) == 'w'){
        answer += "vv";
      }
      else if(nickname.charAt(i) == 'W'){
        answer += "VV";
      }
      else if(nickname.charAt(i) == 'O'){
        answer += "0";
      }
      else{
        answer += nickname.charAt(i);
      }
    }
    if(answer.length() < 3){
      answer += "o".repeat(4 - answer.length());
    }
    if(answer.length() > 8){
      answer = answer.substring(0, 8);
    }
    return answer;
  }

}
