package BOJ.삼성;

import java.util.*;

public class Q_16236_아기상어 {
    static int nowSize = 2;
    static int time = 0;
    static boolean[][] tmpVisited;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[][] cage = new int[n][n];
        tmpVisited = new boolean[n][n];
        boolean[][] visited = new boolean[n][n];
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                cage[i][j] = input.nextInt();
                int tmp = cage[i][j];
                if(tmp == 9) {
                    startX = i;
                    startY = j;
                    visited[i][j] = true;
                    cage[i][j] = 0;
                }
            }
        }
        DFS(startX, startY, n, cage, visited, time);

        System.out.print(result.get(0));
    }

    static int[] goX = {-1, 0, 1, 0};
    static int[] goY = {0, 1, 0, -1};
    static List<Integer> result = new ArrayList<>();
    static int cnt = 0;
    private static void DFS(int x, int y, int n, int[][] cage, boolean[][] visited, int time) {
        if(check(cage, n) == false) {
            result.add(time);
            return;
        }
        for(int i = 0; i < 4; i++){
            int dx = x + goX[i];
            int dy = y + goY[i];

            if((-1 < dx && dx < n) && (-1 < dy && dy < n) && visited[dx][dy] == false && cage[dx][dy] <= nowSize){
                visited[dx][dy] = true;
                time++;

                if(cage[dx][dy] < nowSize && cage[dx][dy] != 0) {
                    cnt++;
                    cage[dx][dy] = 0;
                }

                if(cnt == nowSize) {
                    cnt = 0;
                    visited = tmpVisited;
                    nowSize = nowSize + 1;
                } else {
                    // 아기상어의 크기보다 작으면 그냥 먹기
                    if(cage[dx][dy] < nowSize && cage[dx][dy] != 0) {
                        cage[dx][dy] = 0;
                    }
                }
                DFS(dx, dy, n, cage, visited, time);
            }
        }
    }

    // false 면 모든 값이 0이거나 할 수 있는 값이 없는 것
    public static boolean check(int[][] cage, int n){
        Map<Integer, Integer> tmp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(cage[i][j] != 0) {
                    tmp.put(cage[i][j], tmp.getOrDefault(cage[i][j], 0) + 1);
                }
            }
        }

        Set<Integer> keySet = tmp.keySet();
        for(Integer key : keySet) {
            if(key < nowSize)
                return true;
            else
                return false;
        }
        return false;
    }
}
