package BOJ.BFS_DFS;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 두 노드 사이의 최단 경로 혹은 임의의 경로 => BFS
public class Q_2178_미로탐색 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 4
        int m = input.nextInt(); // 6

        int[][] maze = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String str = input.next();
            for(int j = 0; j < m; j++){
                maze[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        BFS(maze, visited, m, n, 0, 0);

        System.out.println(maze[n-1][m-1]);
    }

    static int[] goX = {0, 1, 0, -1}; // 우 좌
    static int[] goY = {1, 0, -1, 0}; // 하 상
    static public void BFS(int[][] maze, boolean[][] visited, int m, int n, int x, int y){
        Queue xQ = new LinkedList();
        Queue yQ = new LinkedList();
        xQ.add(x); yQ.add(y);
        visited[x][y] = true;

        while (!xQ.isEmpty() && !yQ.isEmpty()){
            x = (int) xQ.poll();
            y = (int) yQ.poll();
            for (int i = 0; i < 4; i++) {
                int dx = x + goX[i];
                int dy = y + goY[i];

                if((-1 < dx && dx < n) && (-1 < dy && dy < m) && maze[dx][dy] == 1 && visited[dx][dy] == false){
                    xQ.add(dx); yQ.add(dy);
                    maze[dx][dy] = maze[x][y] + 1;
                    visited[dx][dy] = true;
                }
            }
        }
    }
}
