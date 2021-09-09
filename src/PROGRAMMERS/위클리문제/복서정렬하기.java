package PROGRAMMERS.위클리문제;

import java.util.ArrayList;
import java.util.List;

public class 복서정렬하기 {
    public static void main(String[] args) {
        int[] weight = {50,82,75,120};
        String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};

        System.out.println(solution(weight, head2head));
    }

    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        List<Float> winRate = new ArrayList<>();
        boolean flag = false;

        // head2head String 자르고 승률계산
        for(int i = 0; i < weights.length; i++){
            float percent = 0f;
            for(int j = 0; j < head2head[i].length(); j++){
                // 검사하는 글자가 W이면 count
            }
            // 승률계산

            if(winRate.contains(percent)){
                flag = true;
            }
            winRate.add(percent);
        }

        // 승률이 같은게 있다
        if(flag){
            // 몸무게 무거운 사람 이긴 count가 더 많을 것 반별

            // count가 높으면 몸무게 비교
        }else{
            // 승률 높은 것부터 return
        }

        return answer;
    }
}
