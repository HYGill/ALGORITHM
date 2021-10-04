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

        // table의 조각을 모두 조사. Map 형식으로 key는 칸의 갯수 뒤에는 list<list>로 저장

        // game_board의 빈칸을 조사
        // if 빈칸이 끝났을 때 빈칸 숫자를 세고 table map 에서 list들 가져옴
        // 가져온 list들 90도씩 회전 시키면서 똑같은거 있는지 확인
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
