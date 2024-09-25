package practice;

public class Sosu {

  public static void main(String[] args) {
    System.out.println(sosuCheck(19));
  }

  public static boolean sosuCheck(long num) {
    if (num <= 1) return false;
    if (num <= 3) return true;
    if (num % 2 == 0 || num % 3 == 0) return false;

    for(long i = 5 ; i*i<=num;i+=6){
      if(num % i == 0 || num % (i+2) == 0){
        return false;
      }
    }

    return true;
  }

}
