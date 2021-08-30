package PROGRAMMERS.위클리문제;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 직업군추천하기 {
    public static void main(String[] args) {
        // 직업군 언어 점수
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        // 개발자가 사용하는 언어
        String[] languages = {"PYTHON", "C++", "SQL"};
        // 언어 선호도
        int[] preference = {7, 5, 5};

        System.out.println(solution(table, languages, preference));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        List<Integer> answer = new ArrayList<>();

        Map<String, List<String>> tableMap = new HashMap<>();
        for(int i = 0; i < table.length; i++){
            String[] tmp = table[i].split(" ");

            List<String> saveList = new ArrayList<>();
            for(int j = 1; j < saveList.size(); j++){
                saveList.add(tmp[j]);
            }
            tableMap.put(tmp[0], saveList);
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
            answer.add(score);
        }

        return null; // 언어 선호도 x 직업군 언어 점수의 총합이 가장 높은 직업군 return
    }
}
