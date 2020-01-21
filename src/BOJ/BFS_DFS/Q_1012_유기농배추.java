package BOJ.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1012_유기농배추 {
    static int [] goX = {-1,1,0,0};
    static int [] goY = {0,0,-1,1};
    static int[][] cabbage;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine()); // 2
        for (int i = 0; i < testCase; i++) {
            String str[] = br.readLine().split(" ");

            M = Integer.parseInt(str[0]); // 가로길이
            N = Integer.parseInt(str[1]); // 세로길이
            int K = Integer.parseInt(str[2]); // 배추 위치 갯수

            int count = 0;

            cabbage = new int[N][M];
            // 배추위치 갯수만큼 자른다.
            for (int j = 0; j < K; j++) {
                str = br.readLine().split(" ");
                // x가 가로고 y가 세로로 저장되어야한다.
                cabbage[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 1이면 4방향 모두 검사해서 0으로 갱신시킨다.
                    if (cabbage[j][k] == 1) {
                        DFS(j, k);
                        cabbage[j][k] = 0;
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void DFS(int y, int x){
        //방문한 곳은 0으로 바꿔줌
        cabbage[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int dx = x + goX[i];
            int dy = y + goY[i];

            if (dx < 0 || dy < 0 || dx >= M || dy >= N) {
                continue;
            }
            //다음 방문할 값이 0 이라면 그냥 통과, 1이 나오면 다 없애야하기때문에
            if (cabbage[dy][dx] == 0) {
                continue;
            }

            DFS(dy, dx);
        }
    }
}
