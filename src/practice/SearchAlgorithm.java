package practice;

public class SearchAlgorithm {

  public static int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid; // 찾은 경우 해당 인덱스를 반환
      }
      if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1; // 찾지 못한 경우 -1을 반환
  }

  public static void main(String[] args) {
    int[] array = {1, 3, 5, 7, 9};
    int target = 3;
    int index = binarySearch(array, target);
    if (index != -1) {
      System.out.println("원소 " + target + "는 인덱스 " + index + "에 위치해 있습니다.");
    } else {
      System.out.println("원소 " + target + "를 찾을 수 없습니다.");
    }
  }


}
