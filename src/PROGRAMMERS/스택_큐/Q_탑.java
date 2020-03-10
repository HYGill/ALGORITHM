package PROGRAMMERS.스택_큐;

import java.util.HashMap;
import java.util.Map;

public class Q_탑 {
    static int[] answer = {};
    public static void main(String[] args) {
        //int[] heights = {3, 9, 9, 3, 5, 7, 2};

        int[] heights = {1, 5, 3, 6, 7, 6, 5};

        System.out.println(solution(heights));
    }
    public static int[] solution(int[] heights) {
        Map<Integer, Integer> heightMap = new HashMap<>();
        answer = new int[heights.length];
        int index = 1;
        for (int i : heights){
            heightMap.put(index, i);
            index++;
        }

        for(int i = heightMap.size(); i > 1; i--){
            if(heightMap.get(i) < heightMap.get(i-1)){
                answer[i-1] = i-1;
            }else {
                for (int j = i-1; j > 1; j--) {
                    if(heightMap.get(i) < heightMap.get(j-1)){
                        answer[i-1] = j-1;
                        break;
                    }else
                        continue;
                }
            }
        }

        return answer;
    }
}
