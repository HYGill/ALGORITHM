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
        
        // list에 담아야할 것(이긴횟수, 몸무게보다 큰 사람한테 이긴 횟수, 자신의 몸무게) => 2차원 배열, 이 정보로 arrays.sort하기
        int[][] info = new int[weights.length][3];

        // head2head String 자르고 승률계산
        for(int i = 0; i < weights.length; i++){
            float percent = 0f;
            int cnt = 0;
            int winHeavyCnt = 0;
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0; j < head2head[i].length(); j++){
                // 검사하는 글자가 W이면 count
                if(head2head[i].charAt(j) == 'W')
                    cnt++;
                    if(weights[i] < weights[j]){
                        winHeavyCnt++;
                    }
            }
            percent = (float)cnt / (float)(head2head[i].length()-1);
            info[i][0] = cnt;
            info[i][1] = winHeavyCnt;
            info[i][2] = weights[i];
            
            winRate.add(percent);
            winWeightCnt(i, winHeavyCnt);
        }

        // 승률이 같은게 있다

        // 몸무게 무거운 사람 이긴 count가 더 많은 것 판별

        // 그것도 같으면 몸무게 비교

        return answer;
    }
}
