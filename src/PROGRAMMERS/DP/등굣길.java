package PROGRAMMERS.DP;

public class 등굣길 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};
        System.out.println(solution(m, n, puddles));
    }

    // m이 가로 n이 세로로 주어지고 puddles가 그 순서대로 들어오니 반대로 생각했어야한다.
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] street = new int[n+1][m+1];
        street[1][0] = 1;

        for (int i = 0; i < puddles.length; i++) {
            street[puddles[i][1]][puddles[i][0]] = -1;
        }
        for (int i = 1; i < street.length; i++) {
            for (int j = 1; j < street[i].length; j++) {
                if(street[i][j] != -1 && street[i-1][j] != -1 && street[i][j-1] != -1)
                    street[i][j] = (street[i-1][j] + street[i][j-1]);
                else if (street[i][j-1] == -1 && street[i][j] != -1)
                    street[i][j] = street[i-1][j];
                else if(street[i-1][j] == -1 && street[i][j] != -1)
                    street[i][j] = street[i][j-1];
            }
        }

        answer = street[n][m] % 1000000007;

        return answer;
    }
}
