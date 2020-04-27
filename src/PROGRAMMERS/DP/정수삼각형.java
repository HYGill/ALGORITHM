package PROGRAMMERS.DP;


public class 정수삼각형 {
    /*
    1. 처음에 트리를 만들어서 DFS로 다 더하고 큰값 찾으려다가 트리가 이상하게 만들어져서 실패 애초에 다만들고 다시 재귀도는것이 시간 초과일듯
    2. 다음으로 배열에서 자신의 -1 0 1 밖에 못 움직이니까 그렇게 경로 찾아서 다더해서 제일 큰값 찾으려다가 BFS해야하는거 또 DFS 하다가 실패
    3. DP라는 것을 생각해보니 아파트 한 것처럼 숫자를 계속 갱신하면 될 것 같아서 그렇게 함
       맨 앞과 맨 뒤빼고 다 분기점에서 max값 선택해서 계속 max가 되게 만들었다
     */
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        int answer = 0;

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(j == 0)
                    triangle[i][j] = triangle[i-1][0] + triangle[i][j];
                else if(i == j)
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i][j];
                else
                    triangle[i][j] = Math.max(triangle[i-1][j-1] + triangle[i][j], triangle[i-1][j] + triangle[i][j]);

                answer = Math.max(answer, triangle[i][j]);
            }
        }

        return answer;
    }
}
