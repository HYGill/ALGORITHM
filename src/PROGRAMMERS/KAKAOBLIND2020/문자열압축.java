package PROGRAMMERS.KAKAOBLIND2020;

import java.util.*;

public class 문자열압축 {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        if(s.length() == 1)
            return 1;
        // LinkedHashSet은 정렬 순서를 유지한다. HashSet은 자동 정렬됨
        Map<String, Integer> map = new HashMap<>();
        String tailString = null;
        for (int i = 1; i < s.length()/2 + 1; i++) {
            List<Info> tmpList = new ArrayList<>();
            int start = i;
            tmpList.add(new Info(s.substring(0, 0 + i), 1));
            while (start < s.length()) {
                String nowString = s.substring(start, start + i);
                String preString = tmpList.get(tmpList.size()-1).nowStr;
                if(preString.equals(nowString))
                    tmpList.get(tmpList.size()-1).cnt += 1;
                else
                    tmpList.add(new Info(nowString, 1));
                start += i;
                if(start + i > s.length()){
                    tailString = s.substring(start, s.length());
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < tmpList.size(); j++){
                if(tmpList.get(j).cnt == 1)
                    sb.append(tmpList.get(j).nowStr);
                else
                    sb.append(tmpList.get(j).cnt + tmpList.get(j).nowStr);
            }
            sb.append(tailString);
            map.put(sb.toString(), i);
        }

        List<Integer> result = new ArrayList<>();
        for(String key : map.keySet()){
            result.add(key.length());
        }
        Collections.sort(result);
        int answer = result.get(0);

        return answer;
    }

    static class Info{
        String nowStr;
        int cnt;
        public Info(String nowStr, int cnt){
            this.nowStr = nowStr;
            this.cnt = cnt;
        }
    }
}
