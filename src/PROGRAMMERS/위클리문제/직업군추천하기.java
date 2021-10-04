import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class 직업군추천하기 {
    public static void main(String[] args) {
        // 직업군 언어 점수
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        // 개발자가 사용하는 언어
        String[] languages = {"JAVA", "JAVASCRIPT"};
        // 언어 선호도
        int[] preference = {7, 5};

        System.out.println(solution(table, languages, preference));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = null;
        List<Integer> result = new ArrayList<>();

        Map<String, List<String>> tableMap = new LinkedHashMap<>();
        List<String> orderMap = new ArrayList<>();
        for(int i = 0; i < table.length; i++){
            String[] tmp = table[i].split(" ");

            List<String> saveList = new ArrayList<>();
            for(int j = 1; j < tmp.length; j++){
                saveList.add(tmp[j]);
            }
            tableMap.put(tmp[0], saveList);
            orderMap.add(tmp[0]);
        }

        Map<String, Integer> scoreMap = new HashMap<>();
        for(int i = 0; i < languages.length; i++){
            scoreMap.put(languages[i], preference[i]);
        }

        for (String key : tableMap.keySet()) {
            int score = 0;
            // list에서 preference 값 찾기
            List<String> newTable = tableMap.get(key);
            for(int i = 0; i < newTable.size(); i++){
                // 선호도 검사map에 현재 String이 있으면
                if(scoreMap.containsKey(newTable.get(i))){
                    score += scoreMap.get(newTable.get(i)) * (5-i);
                }
            }
            result.add(score);
        }
        
        // result 중 가장 높은 점수 찾고
        int resultMax = Collections.max(result);
        int index = result.indexOf(resultMax);

        List<String> sameScore = new ArrayList<>();
        for(int i = 0; i < result.size(); i++){
            if(result.get(i) == resultMax){
                sameScore.add(orderMap.get(i));
            }
        }

        // 그것에 해당하는 tableMap key 값 return
        // 동일한 것이 있으면 사전 순
        if(sameScore.size() == 1){
            answer = orderMap.get(index);
        }else{
            Collections.sort(sameScore);
            answer = sameScore.get(0);
        }
        
        return answer;
    }
}
