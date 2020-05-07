package PROGRAMMERS.카카오개발자겨울인턴쉽2019;

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{0,2,4,4,2},{0,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bowl = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int line = moves[i]-1;
            int preNum = 0;
            for (int j = 0; j < board.length; j++) {
                int tmp = board[j][line];
                if(tmp != 0) {
                    if (!bowl.isEmpty()) {
                        preNum = bowl.peek();
                        bowl.add(tmp);
                    }else {
                        bowl.add(board[j][line]);
                    }
                    board[j][line] = 0;
                    break;
                }
            }
            if(!bowl.isEmpty()) {
                if (preNum == bowl.peek()) {
                    answer += 2;
                    bowl.pop();
                    bowl.pop();
                }
            }
        }
        return answer;
    }
}
