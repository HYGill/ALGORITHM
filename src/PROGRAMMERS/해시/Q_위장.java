package PROGRAMMERS.해시;

import java.util.HashMap;
import java.util.Set;

public class Q_위장 {
    static int answer = 0;
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        // String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        solution(clothes);
    }

    static public void solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++){
            // 옷종류, 종류별 갯수
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }

        // 옷 종류 뽑기
        Set<String> keySet = map.keySet();
        for(String key : keySet) {
            answer *= map.get(key)+1;
        }

        System.out.println(answer-1);
    }
}
