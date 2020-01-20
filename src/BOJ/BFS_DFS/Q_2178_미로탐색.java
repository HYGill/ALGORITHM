package BOJ.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q_2178_미로탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int m = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);

        boolean[][] maze = new boolean[m][n];

        for (int i = 0; i < maze.length; i++) {
            char[] spite = br.readLine().toCharArray();
            for (int j = 0; j < spite.length; j++) {
                maze[i][j] = spite[j] == '1' ? true : false;
            }
        }

        boolean[][] visited = new boolean[m][n];
        int[][] result = new int[m][n];

        Queue dx = new LinkedList<>();
        Queue dy = new LinkedList<>();

        visited[0][0] = true;
        dx.add(0);
        dy.add(0);
        result[0][0] = 1;

        while(!dx.isEmpty()) {
            int x = (int) dx.poll(); // 가장 먼저 보관한 값 꺼내고 반환, 반환하는 것
            int y = (int) dy.poll();
            if(y > 0 && maze[y - 1][x] && visited[y - 1][x] == false) {
                plus(visited, dx, dy, result, x, y - 1, result[y][x]);
            }
            if(y < maze.length - 1 && maze[y + 1][x] && visited[y + 1][x] == false) {
                plus(visited, dx, dy, result, x, y + 1, result[y][x]);
            }
            if(x > 0 && maze[y][x - 1] && visited[y][x - 1] == false) {
                plus(visited, dx, dy, result, x - 1, y, result[y][x]);
            }
            if(x < maze[0].length - 1 && maze[y][x + 1] && visited[y][x + 1] == false) {
                plus(visited, dx, dy, result, x + 1, y, result[y][x]);
            }
        }
        System.out.println(result[m-1][n-1]);
    }

    public static void plus(boolean[][] visited, Queue xs, Queue ys, int[][] result, int x, int y, int prevNode) {
        visited[y][x] = true;
        xs.add(x);
        ys.add(y);
        result[y][x] = prevNode + 1;
    }
}
