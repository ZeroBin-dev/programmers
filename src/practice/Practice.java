package practice;

public class Practice {

  public static void main(String[] args) throws Exception {
    Practice practice = new Practice();

    System.out.println(practice.solution(
      new int[][]{
        {1, 0, 1, 0, 1, 1},
        {1, 0, 1, 0, 0, 0},
        {1, 0, 1, 0, 0, 1},
        {1, 0, 0, 1, 0, 0},
        {1, 0, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 1}
      }));

    System.out.println(practice.solution(
      new int[][]{
        {0, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 1, 1, 0, 0},
        {1, 1, 0, 0, 0, 1, 1, 0},
        {1, 1, 1, 0, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 0, 1, 1}
      }));
  }

  public int solution(int[][] land) {
    int xLen = land[0].length;
    int yLen = land.length;
    long startTime = System.nanoTime();
    for (int x = 0; x < xLen; x++) {
      for(int y =0; y<yLen;y++){
        if(land[y][x] == 1){
          int startX = y;
          int startY = x;
          int endX = y;
          int endY = x;

          boolean flag = true;
          int sum = 0;
          while (flag){
            land[endX][endY] = -1;

            // 오른쪽으로 이동할 수 있으면 오른쪽으로 이동
            if(endY != xLen-1 && land[endX][endY+1] == 1){
              endY++;
              sum++;
            }

            // 아래쪽으로 이동할 수 있으면 아래쪽이동
            else if(endX != yLen -1 && land[endX+1][endY] == 1){
              endX++;
              sum++;
              // 지금꺼 더하고, 지금보다 왼쪽에 있는것들중 0 이며 아니면 한번더이동
              for(int i = endY-1; i >= 0;i--){
                if(land[endX][i] == 0){
                  break;
                }else {
                  land[endX][i] = -1;
                  sum++;
                }
              }
            }

            // 경우2. 오른쪽 아래 모서리에 도착한경우 또는 (오른쪽 끝에 도착했거나, 한칸 오른쪽이 0인 경우) 또한 (아래쪽 끝에 도착했거나 한칸아래쪽이 0인경우)
            if((endX == yLen -1 && endY == x -1) || ((endX == yLen -1 || land[endX+1][endY] == 0) && (endY == xLen-1 || land[endX][endY+1] == 0))){
              flag = false;
              land[endX][endY] = -1;
              sum++;
            }
          }

          // 값 설정
          for(int a = startX;a<=endX;a++){
            for(int b = startY;b<=endY;b++){
              if(land[a][b] == -1){
                land[a][b] = sum;
              }
            }
          }

        }
      }
    }
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);  // 나노초 단위
    System.out.println("Execution time in milliseconds 1: " + duration);


    startTime = System.nanoTime();
    int max = 0;

    for (int x = 0; x < xLen; x++) {
      int v = 0;
      boolean isSum = true;
      for (int y = 0; y < yLen; y++) {
        if(land[y][x] == 0){
          isSum = true;
        } else {
          if(isSum){
            v += land[y][x];
            isSum = false;
          }
        }
      }
      if(isSum){
        v += land[yLen-1][x];
      }
      max = Math.max(max, v);
    }

    endTime = System.nanoTime();
    duration = (endTime - startTime);  // 나노초 단위
    System.out.println("Execution time in milliseconds 2: " + duration);

    return max;
  }


}