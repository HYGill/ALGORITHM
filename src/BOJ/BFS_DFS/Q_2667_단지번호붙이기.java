package BOJ.BFS_DFS;

import java.util.Arrays;
import java.util.Scanner;

public class Q_2667_단지번호붙이기 {
    /*
    input : 입력받을 n*n
    output : 단지개수, 단지의 수 오름차 정렬
     */
    static int[][] map;
    static int[] count;
    static int n = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];

        // 2차원배열로 입력받기
        for(int i = 0; i < n; i++){
            String str = sc.next();
            for(int j=0; j < n; j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        solution();

        System.out.println(count.length - 1);
        Arrays.sort(count);

        for(int i = 0; i < count.length; i++){
            if(count[i] != 0)
                System.out.println(count[i]);
        }
    }

    static int cnt = 1;
    private static void solution() {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // 돌면서 1인 것을 찾으면 DFS(깊이탐색 시작)
                if(map[i][j] == 1){
                    DFS(i, j, ++cnt);
                }
            }
        }

        // cnt 돈 만큼 배열 생성해서 각자 값보다 2낮게해서 저장하기
        count = new int[cnt];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] > 1){
                    count[map[i][j]-1]++;
                }
            }
        }

    }

    static int[] goX = {-1, 0, 1, 0};
    static int[] goY = {0, 1, 0, -1};
    private static void DFS(int x, int y, int cnt) {
        map[x][y] = cnt; //2부터 시작

        for(int i = 0; i < 4; i++){
            // 상하좌우 좌표 돌게하기
            int dx = x + goX[i];
            int dy = y + goY[i];

            // n*n 사이에 있거나 지금 검사하는 값이 1일 때
            if((-1 < dx && dx < n) && (-1 < dy && dy < n) && map[dx][dy] == 1){
                DFS(dx, dy, cnt);
            }
        }

    }
}
