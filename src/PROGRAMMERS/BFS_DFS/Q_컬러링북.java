package PROGRAMMERS.BFS_DFS;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Q_컬러링북 {
    static int m = 0;
    static int n = 0;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> colorGroup = new ArrayList<Integer>(); // color 그룹 저장
    static int[] colorCnt = new int[100]; // 그룹 중 가장 많은 갯수 찾기 위한 배열

    public static void main(String[] args) {
        Scanner input = new Scanner(new InputStreamReader(System.in));
        n = input.nextInt(); // 4
        m = input.nextInt(); // 6

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                map[i][j] = input.nextInt();
            }
        }

        solution();

        Arrays.sort(colorCnt);

        int result = colorCnt[colorCnt.length - 1] + 1; // 처음 0부터 시작했기 때문에 하나 더해준다.

        System.out.println(groupCnt + " " + result);

        input.close();
    }

    static int groupCnt = 0;
    private static void solution() {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    groupCnt++;
                    DFS(i, j);
                }
            }
        }
    }

    static int[] goX = {0, 0, -1, 1};
    static int[] goY = {1, -1, 0, 0};
    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int dx = x + goX[i];
            int dy = y + goY[i];

            if((-1 < dx && dx < n) && (-1 < dy && dy < m) && map[dx][dy] == map[x][y] && !visited[dx][dy]){
                colorCnt[groupCnt]++;
                DFS(dx, dy);
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