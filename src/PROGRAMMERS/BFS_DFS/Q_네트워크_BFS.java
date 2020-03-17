package PROGRAMMERS.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Q_네트워크_BFS {
    static int answer = 0;
    static int n;
    public static void main(String[] args) {
        int[][] numbers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};//2
        //int[][] numbers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};//1
        //int[][] numbers = {{1,0,0,1},{0,1,1,1},{0,1,1,0},{1,1,0,1}};//1
        n = 3;
        //n = 4;
        System.out.println(solution(n, numbers));
    }

    public static int solution(int n, int[][] computers) {
        Queue q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                q.offer (i); // 보관
                answer++;
            }
            while (!q.isEmpty()) {
                int tmp = (int) q.poll();
                visited[tmp] = true;
                for (int j = 0; j < n; j++) {
                    if (j == tmp)
                        continue;
                    if (computers[tmp][j] == 1 && visited[j] == false)
                        q.offer(j); // 보관
                }
            }
        }
        return answer;
    }
}
