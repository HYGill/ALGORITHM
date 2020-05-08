package PROGRAMMERS.카카오개발자겨울인턴쉽2019;


public class 징검다리건너기 {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones, k));
    }

    // 집합의 최댓값 중에 최솟값이 가장 먼저 징검다리 k개가 없어지는 곳
    public static int solution(int[] stones, int k) {
        int min = Integer.MAX_VALUE; //구간의 max 값 중에 최솟값

        // 징검다리 갯수-k만큼 분기문을 돌려준다.
        for (int i = 0; i <= stones.length - k; ) {
            int max = stones[i];//구간의 처음 요소를 max 변수에 추가
            int idx = 0;//다음 i의 위치를 지정할 인덱스 변수

            for (int j = i+1; j < i+k; j++) {//k만큼의 구간 탐색
                if (stones[j] >= max) {//현재 구간의 징검다리가 구간의 최댓값보다 크거나 같을 때
                    idx = j;//인덱스를 현재 징검다리 번호로 변경
                    max = stones[j];//구간의 최댓값을 현재 징검다리로 변경
                }
            }

            if (idx == 0)
                i++;//구간의 최댓값이 변경되지 않았을 때는 한칸만 이동
            else //구간의 최댓값이 변경되었을 때는 최댓값에 해당하는 징검다리 번호+1로 이동
                i = (idx+1);

            min = Math.min(min,max);//구간의 최댓값이 다른 구간과 비교했을 때, 더 작은 구간의 최댓값을 결값에 설정
        }

        return min;
    }
}
