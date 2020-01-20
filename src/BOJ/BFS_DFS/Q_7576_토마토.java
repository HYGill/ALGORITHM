package BOJ.BFS_DFS;

import java.io.IOException;
import java.util.Scanner;

public class Q_7576_토마토 {
    /*
    DFS(깊이우선탐색) : 현재 정점에서 갈 수 있는 점들까지 들어가면서 탐색 (재귀이용)
    BFS(너비우선탐색) : 현재 정점에 연결된 가까운 점들부터 탐색 (큐이용)
    */
    static int[] goX = { 0, 0, -1, 1 };
    static int[] goY = { -1, 1, 0, 0 };
    static int[][] arr;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        m = input.nextInt(); // 가로
        n = input.nextInt(); // 세로
        arr = new int[n+2][m+2];

        for(int j = 0; j < arr[0].length; j++) arr[0][j] = 1;
        for(int j = 0; j < arr[0].length; j++) arr[n+1][j] = 1;
        for(int i = 1; i < arr.length-1; i++) arr[i][0] = 1;
        for(int i = 1; i < arr.length-1; i++) arr[i][m+1] = 1;

        for(int i = 1; i<arr.length - 1; i++) {
            for(int j = 1; j<arr[i].length - 1; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        int cnt = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (arr[i][j] != 1) {
                    DFS(i, j);
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void DFS(int x, int y){
        for (int i = 0; i < 4; i++) {
            int dx = x + goX[i];
            int dy = y + goY[i];

            if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                continue;
            }

            if (arr[dx][dy] == 1) {
                continue;
            }else if(arr[dx][dy] == -1){
                break;
            }

            arr[dx][dy] = 1;
            DFS(dx, dy);
        }
    }
}
