import java.util.Arrays;

public class Q_입국심사 {
    public static void main(String[] args) {
        int n = 6; // 사람 수
        int[] times = {7, 10}; // 각 심사관이 한 명을 심사하는데 걸리는 시간
        
        System.out.println(solution(n, times));
    }
    public static long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long left = 0;
        long right = (long) n * times[times.length - 1]; // 제일 오래걸리는 심사관으로 모두 검사할때가 최대

        while (left <= right) {
            long mid = (left + right) / 2;
            long nowCnt = 0;
            for (int i = 0; i < times.length; i++) {
                nowCnt += mid / times[i]; // 총시간이 mid일때 각 감독관들이 검사한 사람 수 cnt
            }

            // 검사해야되는 사람보다 적으면 -> 시간 더 필요
            if (nowCnt < n) {
                // 검사시간 늘리기
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}
