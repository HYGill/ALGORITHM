package PROGRAMMERS.BFS_DFS;

public class Q_네트워크_2021 {
    static boolean[][] visited;
    public static void main(String[] args) {
        int n = 3; 
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int cnt = 0;
        visited = new boolean[computers.length][computers[0].length]; // boolean의 기본값 false, Boolean의 기본값 null

        for(int i = 0; i < n; i++){
            // 방문을 하지 않았고 1이라면
            if(visited[i][i] == false){
                visited[i][i] = true;
                dfs(i, n, computers);

                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int start, int n, int[][] computers){
        for(int i = 0; i < n; i++){
            if(computers[start][i] == 1 && visited[start][i] == false){
                visited[start][i] = true;
                dfs(i, n, computers);
            }
        }
    }
}
