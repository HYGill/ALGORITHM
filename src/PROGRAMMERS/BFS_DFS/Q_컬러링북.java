package PROGRAMMERS.BFS_DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q_컬러링북 {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        //int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        System.out.println(solution(m, n, picture));
    }

    static int cnt;
    static public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        List<Integer> numCnt = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                int now = picture[i][j];
                if(visited[i][j] == false && now != 0){
                    visited[i][j] = true;
                    cnt = 1;
                    DFS(m, n, picture, visited, i, j, now);
                    numCnt.add(cnt);
                }
            }
        }

        Collections.sort(numCnt, Collections.reverseOrder());
        answer[0] = numCnt.size();
        answer[1] = numCnt.get(0);

        return answer;
    }

    static int[] goX = {0, 1, 0, -1}; // 우 좌
    static int[] goY = {1, 0, -1, 0}; // 하 상
    private static void DFS(int m, int n, int[][] picture, boolean[][] visited, int x, int y, int now) {
        for(int i = 0; i < 4; i++){
            int dx = x + goX[i];
            int dy = y + goY[i];

            if((-1 < dx && dx < m) && (-1 < dy && dy < n) && picture[dx][dy] == now && picture[dx][dy] != 0 && visited[dx][dy] == false){
                visited[dx][dy] = true;
                cnt++;
                DFS(m, n, picture, visited, dx, dy, now);
            }
        }
    }
}
/*
6 4
1 1 1 0
1 2 2 0
1 0 0 1
0 0 0 1
0 0 0 3
0 0 0 3

6 4
1 1 1 0
1 1 1 0
0 0 0 1
0 0 0 1
0 0 0 1
0 0 0 1

결과 2 6
 */