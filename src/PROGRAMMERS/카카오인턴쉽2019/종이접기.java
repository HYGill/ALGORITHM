package PROGRAMMERS.카카오인턴쉽2019;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 종이접기 {
    public static void main(String[] args) {
        int n = 5;
        /*
1	[0]
2   [0,0,1]
3   [0,0,1, 0, 0,1,1]
4   [0,0,1, 0, 0,1,1, 0, 0,0,1, 1, 0,1,1] // 001
5   [0,0,1, 0, 0,1,1, 0, 0,0,1, 1, 0,1,1, 0, 0,0,1, 0, 0,1,1, 1, 0,0,1, 1, 0,1,1] // 0010011
         */
        System.out.println(solution(n));
    }

    static public int[] solution(int n) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> repeat = new LinkedList<>(){{
            add(0);add(0);add(1);add(0);add(1);add(1);
        }};

        switch (n){
            case 1:
                result.add(0);
                break;
            case 2:
                result.add(0);result.add(0);result.add(1);
                break;
            default:
                for (int i = 0; i < (int) Math.pow(2,(n-2)); i++) {
                    for (int j = 0; j < 3; j++){
                        int tmp = repeat.poll();
                        result.add(tmp);
                        repeat.add(tmp);
                    }
                    int nowNum = result.get(i);
                    result.add(nowNum);
                }
                result.remove(result.size()-1);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
            System.out.print(answer[i]);
        }

        return answer;
    }
}
