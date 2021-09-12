package PROGRAMMERS.위클리문제;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            int cnt = 0;
            for(int j = 0; j < head2head[i].length(); j++){
                // 검사하는 글자가 W이면 count
                if(head2head[i].charAt(j) == 'W')
                    cnt++;
            }
            // 승률계산
            percent = (float)cnt / (float)(head2head[i].length()-1);

            if(winRate.contains(percent)){
                flag = true;
            }
            winRate.add(percent);
        }

        // 승률이 같은게 있다
        if(flag){
            // 몸무게 무거운 사람 이긴 count가 더 많은 것 판별
            
            // 그것도 같으면 몸무게 비교
        }else{
            // 승률 높은 것부터 return
            Map<Float, Integer> compareMap = new HashMap<>();
            for(int i = 0; i < weights.length; i++){
                compareMap.put(winRate.get(i), weights[i]);
            }

            Collections.reverse(winRate);

            for(int i = 0; i < weights.length; i++){
                answer[i] = compareMap.get(winRate.get(i));
            }
        }

        return answer;
    }
}
