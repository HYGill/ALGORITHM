package PROGRAMMERS.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현 {
    public static void main(String[] args) {
        int n = 5;
        int number = 3600;
        System.out.println(solution(n, number));
    }

    public static int solution(int N, int number) {
        List<Set<Integer>> arr = new ArrayList<>();

        if(N == number)
            return 1;

        for (int i = 1; i < 9; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < i; j++) {
                tmp.append(N);
            }
            Set<Integer> tmp2 = new HashSet<>();
            tmp2.add(Integer.parseInt(tmp.toString()));
            arr.add(tmp2);
        }

        for (int i = 1; i < arr.size(); i++) {
            for (int j = 0; j < i; j++) {
                for (int in : arr.get(j)) {
                    // 계산 앞과 뒤가 바뀌면 값도 바뀜으로 한번 교환해서 다시 넣어주어야한다.
                    for (int in2 : arr.get(i-j-1)) {
                        arr.get(i).add(in + in2);
                        arr.get(i).add(in - in2);
                        arr.get(i).add(in * in2);
                        if(in2 != 0)
                            arr.get(i).add(in/in2);
                    }
                }
            }
            if(arr.get(i).contains(number))
                return i+1;
        }
        return -1;
    }
}
