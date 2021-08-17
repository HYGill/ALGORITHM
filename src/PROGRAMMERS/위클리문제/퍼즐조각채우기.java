package PROGRAMMERS.위클리문제;

/*
* DFS : Stack, Recursion
* BFS : Queue
*/

public class 퍼즐조각채우기 {
    public static void main(String[] args) {
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}}; 
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
        int answer = -1;

        boolean[][] visited = new boolean[game_board.length][game_board.length];
        for(int i = 0; i < game_board.length; i++){
            for(int j = 0; j < game_board[i].length; j++){
                if(!visited[i][j]){
                    dfs(i, j, game_board, table, visited);
                }
            }
        }


        System.out.println(answer); 
    }

    static int[] goX = {0, 1, 0, -1}; // 우 좌
    static int[] goY = {1, 0, -1, 0}; // 하 상
    public static void dfs(int i, int j, int[][] game_board, int[][] table, boolean[][] visited){
        for(int k = 0; k < 4; k++){
            int dx = i + goX[k];
            int dy = j + goY[k];

            if((-1 < dx && dx < i) && (-1 < dy && dy < j) && table[dx][dy] == 1 && table[dx][dy] != 0 && visited[dx][dy] == false){
                visited[dx][dy] = true;
                dfs(i, j, game_board, table, visited);
            }
        }
    }
}
