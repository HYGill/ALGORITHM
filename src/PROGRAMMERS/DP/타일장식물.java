package PROGRAMMERS.DP;

public class 타일장식물 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(solution(n));
    }

    public static long solution(int N) {
        long answer = DP(N) * 2;

        return answer;
    }

    public static long DP(int n){
        long[] num = new long[80];
        num[0] = (long)1;
        num[1] = (long)2;

        int i = 2;
        while (true){
            num[i] = num[i-1] + num[i-2];
            if(i == n-1)
                return num[i] + num[i-1];
            i++;
        }
    }
}
