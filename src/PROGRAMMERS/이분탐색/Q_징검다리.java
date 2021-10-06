public class Q_징검다리 {
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17}; 
        int n = 2;
        
        System.out.println(solution(distance, rocks, n));
    }

    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        int left = 0;
        int right = distance;
        int mid = (left+right)/2;

        while(left < right){
            // mid는 각 바위 사이 거리 중 최솟값에서 가장 큰 값을 뜻함
            // mid 보다 작은 거리는 삭제처리하고 큰 거리만 살렸을 시 n 비교


            // n보다 많이 삭제되었으면 right = mid + 1;
            // n보다 적게 삭제되었으면 rigth += 1;
        }

        return answer;
    }
}
