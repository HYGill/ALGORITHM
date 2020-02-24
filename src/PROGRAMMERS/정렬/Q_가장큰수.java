package PROGRAMMERS.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q_가장큰수 {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        String[] sNum = new String[numbers.length];
        for(int i= 0; i < numbers.length ; i++) {
            sNum[i] = Integer.toString(numbers[i]);
        }

        System.out.println(solution(sNum));
    }

    public static String solution(String[] numbers) {
        String answer = "";
        List<String> tmp = new ArrayList<>();

        Arrays.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(numbers[0].startsWith("0")) {
            answer += "0";
        } else {
            for(int j=0; j < numbers.length; j++) {
                answer += numbers[j];
            }
        }

        return answer;
    }
}
