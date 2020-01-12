package PROGRAMMERS.greedy;

import java.util.Arrays;
import java.util.Comparator;

class Q_단속카메라 {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int start = routes[0][0];
        int end = routes[0][1];
        for (int i = 1; i < routes.length; i++){
            if (!(routes[i][0] >= start && routes[i][0] <= end)){
                start = routes[i][0];
                end = routes[i][1];
                answer++;
            }else{
                start = start > routes[i][0] ? start : routes[i][0];
                end = end < routes[i][1] ? end : routes[i][1];
            }
        }
        return answer;
    }
}