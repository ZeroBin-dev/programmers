package practice;

import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * Level 0
 * 쉬운문제
 */
public class Level0_easy {

  /**
   * No : 1
   * title : 숫자 비교하기
   * desc : 정수 num1과 num2가 매개변수로 주어집니다. 두 수가 같으면 1 다르면 -1을 retrun 하도록 solution 함수를 완성해주세요.
   */
  public static int solution1(int num1, int num2) {
    return num1 == num2 ? 1 : -1;
  }

  /**
   * No : 2
   * title : 나머지 구하기
   * desc : 정수 num1, num2가 매개변수로 주어질 때, num1를 num2로 나눈 나머지를 return 하도록 solution 함수를 완성해주세요.
   */
  public static int solution2(int num1, int num2) {
    return num1 % num2;
  }

  /**
   * No : 3
   * title : 두 수의 곱
   * desc : 정수 num1, num2가 매개변수 주어집니다. num1과 num2를 곱한 값을 return 하도록 solution 함수를 완성해주세요.
   */
  public static int solution3(int num1, int num2) {
    return num1 * num2;
  }

  /**
   * No : 4
   * title : 두 수의 차
   * desc : 정수 num1과 num2가 주어질 때, num1에서 num2를 뺀 값을 return하도록 soltuion 함수를 완성해주세요.
   */
  public static int solution4(int num1, int num2) {
    return num1 - num2;
  }

  /**
   * No : 5
   * title : 몫 구하기
   * desc : 정수 num1, num2가 매개변수로 주어질 때, num1을 num2로 나눈 몫을 return 하도록 solution 함수를 완성해주세요.
   */
  public static int solution5(int num1, int num2) {
    return num1 / num2;
  }

  /**
   * No : 6
   * title : 나이 출력
   * desc : 머쓱이는 40살인 선생님이 몇 년도에 태어났는지 궁금해졌습니다. 나이 age가 주어질 때, 2022년을 기준 출생 연도를 return 하는 solution 함수를 완성해주세요.
   */
  public static int solution6(int age) {
    return 2022 - age + 1;
  }

  /**
   * No : 7
   * title : 두 수의 합
   * desc : 정수 num1과 num2가 주어질 때, num1과 num2의 합을 return하도록 soltuion 함수를 완성해주세요.
   */
  public static int solution7(int num1, int num2) {
    return num1 + num2;
  }

  /**
   * No : 8
   * title :
   */
  public static int solution8(int num1, int num2){
    return (int)(((double)num1/num2)*1000);
  }

  public static void main(String[] args) {

    //LongStream.iterate(x, i->i+x).limit(n).toArray();



    /*int n = 123;
    int result = String.valueOf(n).chars().map(Character::getNumericValue).sum();
    System.out.println(result);*/

    // System.out.println(String.valueOf(n).chars().mapToObj(c -> String.valueOf((char) c)).reduce("", (a, b) -> b + a));

    // new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray()

    // long n = 12345;
    //    int result[] = new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    //    Arrays.stream(result).forEach(i -> System.out.print(i+" "));


    //StringBuilder sb = new StringBuilder(my_string);
    //    sb.replace(s, s+overwrite_string.length(), overwrite_string);
    //
    //    return sb.toString();

    // String first = my_string.substring(0, s);
    //    String last = my_string.substring(s+overwrite_string.length());
    //    return first+overwrite_string+last;

    // return String.join("", arr);

    // return IntStream.range(0, k).mapToObj(i -> my_string).collect(Collectors.joining()); -> my_string.repeat(k);

    // Math.max(Integer.parseInt(a+""+b), Integer.parseInt(b+""+a));

    // return IntStream.range(0, included.length).map(idx -> included[idx] ? a+(idx*d) : 0).sum();

    // return control.chars().reduce(n, (acc, c) -> acc + (c == 'w' ? 1 : c == 's' ? -1 : c == 'd' ? 10 : -10));

    // Map<Integer, Long> map = Arrays.stream(array).mapToObj(i -> i).collect(
    //      Collectors.groupingBy(
    //        Function.identity(), Collectors.counting()
    //      )
    //    );
    //
    //    long max = map.values().stream().mapToLong(Long::longValue).max().orElse(0L);
    //
    //    List<Integer> list = map.keySet().stream().filter(i -> map.get(i) == max).collect(Collectors.toList());
    //
    //    return list.size() > 1 ? -1 : list.get(0);
    // Arrays.stream(strList).mapToInt(String::length).toArray()
    // Arrays.copyOfRange(numbers, num1, num2 + 1);

    // for(int i=0;i<query.length;i++){
    //      int cur = query[i];
    //      if(i%2 == 1){
    //        // 홀수 인덱스(arr[cur] 앞은 자르기)
    //        arr = Arrays.copyOfRange(arr, cur, arr.length); // 앞 자르기
    //      } else {
    //        // 짝수 인덱스(arr[cur] 뒤는 자르기)
    //        arr = Arrays.copyOfRange(arr, 0, cur+1); // 뒤 자르기
    //      }
    //    }
    //
    //    return arr;

    //public static int[] solution(int[] numlist, int n) {
    //    Integer[] sorted = Arrays.stream(numlist)
    //      .boxed()
    //      .sorted((cur, pre) -> { // -1 이면 변경 1이면 유지
    //        int absCur = Math.abs(cur - n);
    //        int absPre = Math.abs(pre - n);
    //        if(absCur == absPre){
    //          return Integer.compare(cur, pre)*-1;
    //        } else {
    //          return Integer.compare(absCur, absPre);
    //        }
    //      })
    //      .toArray(Integer[]::new);
    //
    //    return Arrays.stream(sorted).mapToInt(i -> i).toArray();
    //  }

    // B.repeat(2).indexOf(A); 오른쪽으로 이동했을때의 횟수

    // return IntStream.range(0, rank.length)
    //      .filter(i -> attendance[i])
    //      .boxed()
    //      .sorted(Comparator.comparing(i -> rank[i]))
    //      .limit(3L)
    //      .reduce((current, next) -> current * 100 + next)
    //      .get();

    // int max = Math.max(arr.length, arr[0].length);
    //    int[][] array = new int[max][max];
    //    for(int i =0;i<arr.length;i++){
    //      System.arraycopy(arr[i], 0, array[i], 0, arr[0].length);
    //    }
    //    return array;

    // return Long.parseLong(
    //      String.valueOf(n).chars()
    //        .mapToObj(ch -> (char) ch)
    //        .sorted(Comparator.reverseOrder())
    //        .map(String::valueOf)
    //        .collect(Collectors.joining())
    //    );

    // return my_string.replaceAll("[aeiou]", "");

    // my_string = my_string.replaceAll("\\D", ""); // 숫자만 찾기

    // return Arrays.stream(numbers).reduce(0, (acc, i) -> n >= acc ? acc + i : acc);

    // return Arrays.stream(num_list).sorted().limit(5).toArray();

    // return IntStream.of(numList).anyMatch(num -> num == n) ? 1 : 0;

    // return Arrays.stream(numList).sorted().skip(5).toArray();

    // IntStream.rangeClosed(end_num, start).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

    // int result[] = new int[num_list.length];
    //    for(int i=0;i<num_list.length;i++){
    //      int idx = (i+num_list.length-n)%num_list.length;
    //      result[idx] = num_list[i];
    //    }
    //
    //    return result;

    // return myString.trim().split("\\s+");

    // return num_str.chars().mapToObj(ch -> (char)ch).mapToInt(Character::getNumericValue).sum();
    // return numStr.chars().map(c -> c - 48).sum();
    // return Arrays.stream(arr).filter(i -> Arrays.stream(delete_list).noneMatch(j -> j == i)).toArray();
    // return myString.replaceAll("[^l-z]", "l");

    // List<String> list = Arrays.stream(myString.split("")).collect(Collectors.toList());
    //
    //        Collections.swap(list, num1, num2);
    //        return String.join("", list);

    // return Arrays.stream(intervals).flatMapToInt(ints -> Arrays.stream(Arrays.copyOfRange(arr, ints[0], ints[1] + 1))).toArray();

    // int size = numbers.length;
    //    int[] answer = new int[size];
    //    for(int i = 0;i< size;i++){
    //      if("right".equals(direction)){
    //        answer[i] = numbers[(size-1+i)%size]; // 오른쪽이동
    //      } else {
    //        answer[i] = numbers[(i+1)%size]; // 왼쪽이동
    //      }
    //    }
    //
    //    return answer;

    // return String.valueOf(age).chars().mapToObj(operand -> String.valueOf((char) (49 + operand))).collect(Collectors.joining());

    // return (int) IntStream.rangeClosed(1, n).filter(i -> (int) IntStream.rangeClosed(1, i).filter(i2 -> i % i2 == 0).count() > 2).count();

    // return phone_number.replaceAll(".(?=.{4})", "*");

    // return Arrays.stream(myString.split("[A-Z|a-z]")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).sum();

    // String[] arr = Arrays.stream(myStr.split("[abc]+")).filter(str -> !str.isEmpty()).toArray(String[]::new);
    //        return arr.length == 0 ? new String[] { "EMPTY" } : arr;

    // Map<Integer, Long> lengthCounts = Arrays.stream(strArr)
    //      .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    //
    //    int maxLength = lengthCounts.values().stream()
    //      .mapToInt(Long::intValue)
    //      .max()
    //      .orElse(0);
    //
    //
    //    return maxLength;

    // ArrayList<Integer> list = new ArrayList<>();
    //    for (int i = 2; i <= n; i++) {
    //      while (n % i == 0) {
    //        list.add(i);
    //        n /= i;
    //      }
    //    }
    //
    //    HashSet<Integer> hashSet = new HashSet<>(list);
    //
    //    int[] uniqueArray = new int[hashSet.size()];
    //    int index = 0;
    //    for (int element : hashSet) {
    //      uniqueArray[index++] = element;
    //    }
    //
    //    return Arrays.stream(uniqueArray).sorted().toArray();
    // return Arrays.stream(myString.replaceAll("- ", "-").replaceAll("[+] ", "").trim().split(" ")).mapToInt(Integer::parseInt).sum();
    //
    // int len = Math.max(a.length(), b.length());
    //    int[] one = new int[len];
    //    int[] two = new int[len];
    //    int[] temp_a = Arrays.stream(a.split("")).mapToInt(Integer::parseInt).toArray();
    //    System.arraycopy(temp_a, 0, one, len - temp_a.length, temp_a.length); // 왼쪽을 0 으로 채우기
    //
    //    int[] temp_b = Arrays.stream(b.split("")).mapToInt(Integer::parseInt).toArray();
    //    System.arraycopy(temp_b, 0, two, len - temp_b.length, temp_b.length); // 왼쪽을 0 으로 채우기
    //
    //    int[] answer = new int[len];
    //    int up = 0;
    //    for (int i = len - 1; i >= 0; i--) {
    //      int add = one[i] + two[i] + up;
    //      if (add >= 10) {
    //        answer[i] = add - 10;
    //        up = 1;
    //      } else {
    //        answer[i] = add;
    //        up = 0;
    //      }
    //    }
    //
    //    if(up == 1){
    //      int[] newArray = new int[len + 1];
    //      newArray[0] = 1;
    //      System.arraycopy(answer, 0 , newArray, 1, len);
    //      return Arrays.stream(newArray).mapToObj(String::valueOf).collect(Collectors.joining());
    //    } else {
    //      return Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining());
    //    }
    // BigInteger n = IntStream.rangeClosed(1, balls).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
    //    BigInteger m = IntStream.rangeClosed(1, share).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
    //    BigInteger mn = IntStream.rangeClosed(1, balls-share).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
    //
    //    return n.divide(mn.multiply(m)).intValueExact();
    // return IntStream.concat(Arrays.stream(arr).distinct(), IntStream.range(0, k).map(i -> -1)).limit(k).toArray();
    // String[] list = s.split(" ", -1);
    //    for(int i = 0;i<list.length;i++){
    //      String l = list[i];
    //      if(!"".equals(l)){
    //        if(l.length() == 1){
    //          list[i] = String.valueOf(Character.toUpperCase(l.charAt(0)));
    //        } else {
    //          list[i] = Character.toUpperCase(l.charAt(0))+l.toLowerCase().substring(1, l.length());
    //        }
    //      }
    //    }
    //
    //    return String.join(" ", list);
    // return list.stream().mapToInt(Integer::intValue).toArray();
    // String str = "";
    //
    //    while (n != 0) {
    //      str += n % 3;
    //      n /= 3;
    //    }
    //
    //    return Integer.parseInt(str, 3);

    /**피보나치 수열*/
    // // n이 0이거나 1인 경우 예외 처리
    //    if (n == 0) return 0;
    //    if (n == 1) return 1;
    //
    //    BigInteger[] fib = new BigInteger[n + 1];
    //    fib[0] = BigInteger.ZERO;
    //    fib[1] = BigInteger.ONE;
    //
    //    for (int i = 2; i <= n; i++) {
    //      fib[i] = fib[i - 1].add(fib[i - 2]);
    //    }
    //
    //    return fib[n].mod(BigInteger.valueOf(1234567)).intValue();
    //
    // StringBuilder sb = new StringBuilder(s);
    //
    //    for (int i = 0; i < sb.length(); i++) {
    //      if (sb.charAt(i) != ' ') {
    //        int ch = sb.charAt(i) + n;
    //        if (Character.isUpperCase(sb.charAt(i)) && ch > 'Z') {
    //          ch = ch - ('Z' - 'A' + 1);
    //        } else if (Character.isLowerCase(sb.charAt(i)) && ch > 'z') {
    //          ch = ch - ('z' - 'a' + 1);
    //        }
    //
    //        sb.replace(i, i + 1, String.valueOf((char) ch));
    //      }
    //
    //    }
    //
    //    return sb.toString();
    // Stack<Character> stack = new Stack<>();
    //    stack.push(s.charAt(0));
    //    for(int i = 1 ;i<s.length();i++){
    //      if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
    //        stack.pop();
    //      }else{
    //        stack.push(s.charAt(i));
    //      }
    //    }
    //
    //    return stack.isEmpty() ? 1 : 0;

    //  new_id = new_id.toLowerCase(); // 1단계
    //        new_id = new_id.replaceAll("[^a-z0-9-_.]", ""); // 2단계
    //        new_id = new_id.replaceAll("\\.{2,}", "."); // 3단계
    //        new_id = new_id.replaceAll("^\\.|\\.$", ""); // 4단계
    //        if(new_id.equals("")){
    //          new_id = "a";
    //        } // 5단계
    //        if(new_id.length() > 15){
    //          new_id = new_id.substring(0, 15);
    //          if(new_id.charAt(new_id.length()-1) == '.'){
    //            new_id = new_id.substring(0, 14);
    //          }
    //        } // 6단계
    //        if(new_id.length() <= 2){
    //          while (new_id.length() < 3){
    //            new_id += new_id.charAt(new_id.length()-1);
    //          }
    //        } // 7단계
    //
    //        return new_id;
    // Arrays.sort(strings, (a, b) -> {
    //      char charA = a.charAt(n);
    //      char charB = b.charAt(n);
    //      if (charA == charB) {
    //        return a.compareTo(b);
    //      } else {
    //        return Character.compare(charA, charB);
    //      }
    //    });
    //    return strings;

    /**
     * public int solution(int[] arrayA, int[] arrayB) {
     *     Arrays.sort(arrayA);
     *     Arrays.sort(arrayB);
     *
     *     int maxA = getMax(arrayA);
     *     int maxB = getMax(arrayB);
     *
     *     if(maxA == 1 && maxB != 1){
     *       return maxB;
     *     }
     *
     *     else if(maxA != 1 && maxB == 1){
     *       return maxA;
     *     }
     *
     *     else {
     *       for(int num : arrayB){
     *         if(num % maxA == 0) return 0;
     *       }
     *
     *       for(int num : arrayA){
     *         if(num % maxB == 0) return 0;
     *       }
     *     }
     *
     *     return Math.max(maxA, maxB);
     *   }
     *
     *    3개 숫자의 최대공약수
     *   private int getMax(int[] arr) {
     *
     *     for (int i = arr[0]; i > 1; i--) {
     *       if (arr[0] % i == 0) {
     *         boolean isPos = true;
     *         for (int j = 1; j < arr.length; j++) {
     *           if (arr[j] % i != 0) {
     *             isPos = false;
     *             break;
     *           }
     *         }
     *         if (isPos) {
     *           return i;
     *         }
     *       }
     *     }
     *
     *     return 1;
     *   }
     * */
    /**
     * /**
     *    * 효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
     *    * (1칸, 1칸, 1칸, 1칸)
     *    * (1칸, 2칸, 1칸)
     *    * (1칸, 1칸, 2칸)
     *    * (2칸, 1칸, 1칸)
     *    * (2칸, 2칸)
     *    * 의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 예를 들어 4가 입력된다면, 5를 return하면 됩니다.
     *    * *
     *public long solution ( int n){
     *if (n == 1) return 1;
     *
     *int MOD = 1234567;
     *int[] dp = new int[n + 1];
     *dp[1] = 1;
     *dp[2] = 2;
     *for (int i = 3; i <= n; i++) {
     *dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
     *}
     *return dp[n];
     *}
     * */
    /**
     *
     *
     *
     * /**
     *    * 문제 설명
     *    * 아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
     *    *
     *    * 12 = 5 + 5 + (5 / 5) + (5 / 5)
     *    * 12 = 55 / 5 + 5 / 5
     *    * 12 = (55 + 5) / 5
     *    *
     *    * 5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
     *    * 이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.
     *    *
     *    * 제한사항
     *    * N은 1 이상 9 이하입니다.
     *    * number는 1 이상 32,000 이하입니다.
     *    * 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
     *    * 최솟값이 8보다 크면 -1을 return 합니다.
     *    *
     *    * return 4
     *
     * public int solution(int N, int number) {
     *     // N의 사용 횟수별로 가능한 모든 결과를 저장하기 위한 리스트
     *     List<Set<Integer>> results = new ArrayList<>();
     *
     *     // N을 1부터 8까지 사용한 경우의 결과를 계산하여 리스트에 저장
     *     for (int i = 0; i < 8; i++) {
     *       Set<Integer> result = new HashSet<>();
     *       int num = 0;
     *       for (int j = 0; j <= i; j++) {
     *         num = num * 10 + N;
     *       }
     *       result.add(num);
     *       results.add(result);
     *     }
     *
     *     // 한번에 되는지
     *     if(results.get(0).contains(number)){
     *       return 1;
     *     }
     *
     *     // 2~8번 사이에 되는지
     *     for (int i = 1; i < 8; i++) {
     *       for (int j = 0; j < i; j++) {
     *         for (int a : results.get(j)) {
     *           for (int b : results.get(i - j - 1)) {
     *             results.get(i).add(a + b);
     *             results.get(i).add(a - b);
     *             results.get(i).add(a * b);
     *             if (b != 0) {
     *               results.get(i).add(a / b);
     *             }
     *           }
     *         }
     *       }
     *       // number가 결과에 포함되어 있다면 최소 횟수 리턴
     *       if (results.get(i).contains(number)) {
     *         return i + 1;
     *       }
     *     }
     *
     *     // number를 만들 수 없는 경우 -1 리턴
     *     return -1;
     *   }
     * */

    /**
     *
     * 위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다.
     *    * 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.
     *    * <p>
     *    * 삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.
     *    * <p>
     *    * 제한사항
     *    * 삼각형의 높이는 1 이상 500 이하입니다.
     *    * 삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.
     *
     * public int solution(int[][] triangle) {
     *         for (int i = 1; i < triangle.length; i++) {
     *             triangle[i][0] += triangle[i-1][0];
     *             triangle[i][i] += triangle[i-1][i-1];
     *             for (int j = 1; j < i; j++)
     *                 triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
     *         }
     *
     *         return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
     *     }
     *
     * */

    /**
     * int[][] dp = new int[n][m];
     *         dp[0][0] = 0;
     *
     *         // 물 잠긴 위치는 -1로
     *         for (int[] puddle : puddles) {
     *           dp[puddle[1] - 1][puddle[0] - 1] = -1;
     *         }
     *
     *         for (int i = 0; i < n; i++) {
     *           for (int j = 0; j < m; j++) {
     *             if (i == 0 && j == 0) {
     *               continue;
     *             } else if (dp[i][j] == -1) {
     *               dp[i][j] = 0;
     *             } else {
     *
     *               // 제일 윗 줄인데 왼쪽이 막혀있으면 0
     *               if ((i == 0 && j != 1 && dp[i][j - 1] == 0) || (j == 0 && i != 1 && dp[i-1][j] == 0)) {
     *                 dp[i][j] = 0;
     *               } else {
     *                 if (i == 0 || j == 0) {
     *                   dp[i][j] = 1;
     *                 } else {
     *                   dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
     *                 }
     *               }
     *             }
     *           }
     *         }
     *
     *         return dp[n - 1][m - 1];
     */

    /**
     * 탐욕법
     */
//    public int solution(int[] people, int limit) {
//      int answer = 0;
//
//      Arrays.sort(people);
//
//      int start = 0;
//      int end = people.length - 1;
//
//      while(start <= end){
//
//        if(people[start] + people[end] <= limit){
//          start++;
//        }
//
//        end--;
//        answer++;
//      }
//
//      return answer;
//    }

    System.out.println("end");
  }

}
