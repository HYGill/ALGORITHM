package PROGRAMMERS.BFS_DFS;

public class Q_네트워크 {
	static int answer = 0;
	static boolean[][] visited;
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
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			if (!visited[i][i]) {
				dfs(i, n, computers);
				answer++;
			}
		}
		return answer;
	}

	static void dfs(int start, int n, int[][] computers) {
		for (int i = 0; i < n; i++) {
			if (computers[start][i] == 1 && !visited[start][i]) {
				visited[start][i] = visited[i][start] = true;
				dfs(i, n, computers);
			}
		}
	}
}