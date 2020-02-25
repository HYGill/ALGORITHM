package PROGRAMMERS.정렬;

import java.util.Arrays;

public class Q_Hindex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        System.out.println(solution(citations));
    }

    static public int solution(int[] citations) {
        int answer = 0;
        int h = 0;
        int k = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            h = citations[i];
            k =  citations.length - i;
            if (k <= h) {
                answer = k;
                break;
            }
        }
        return answer;
    }
}
