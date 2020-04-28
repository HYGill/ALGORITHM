package PROGRAMMERS.DP;

import java.util.Arrays;

public class 카드게임 {
    static int[][] memo; // 최적해를 넣는다

    public static void main(String[] args) {
        int[] left = {3, 2, 5};
        int[] right = {2, 4, 7};
        System.out.println(solution(left, right));
    }

    public static int solution(int[] left, int[] right) {
        memo = new int[left.length][right.length];
        for (int i = 0; i < left.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return helper(left, right, 0, 0);
    }

    public static int helper(int[] left, int[] right, int leftInd, int rightInd) {
        // 다보면 끝
        if (left.length == leftInd || right.length == rightInd) {
            return 0;
        }
        if (memo[leftInd][rightInd] != -1) {
            //이미 최적값을 찾은 상태
            return memo[leftInd][rightInd];
        }
        if (right[rightInd] < left[leftInd]) {
            // 오른쪽 카드가 더 작다면 오른쪽 카드를 버리고 더해준다
            int currAns = helper(left, right, leftInd, rightInd + 1) + right[rightInd];

            // 계산한 값을 memoization 테이블에 저장
            memo[leftInd][rightInd] = currAns;
            return currAns;
        } else {
            // 왼쪽카드만 버리거나 오른쪽카드와 왼쪽카드를 둘다 버리고 그 둘중 최적값을 계산
            int currAns = Math.max(helper(left, right, leftInd + 1, rightInd + 1),
                    helper(left, right, leftInd + 1, rightInd));

            // 최적값을 memoization 테이블에 저장
            memo[leftInd][rightInd] = currAns;
            return currAns;
        }
    }
}