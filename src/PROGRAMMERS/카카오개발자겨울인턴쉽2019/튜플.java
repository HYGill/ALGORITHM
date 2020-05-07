package PROGRAMMERS.카카오개발자겨울인턴쉽2019;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class 튜플 {
    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        System.out.println(solution(s));
    }

    public static int[] solution(String s) {
        LinkedHashSet<Integer> set = new LinkedHashSet();
        Map<Integer, String> map = new HashMap<>();
        int repeat = 1;
        while (repeat < s.length()-1){
            if(s.charAt(repeat) == '{'){
                StringBuilder tmpSb = new StringBuilder();
                while (s.charAt(repeat) != '}') {
                    tmpSb.append(s.charAt(repeat));
                    repeat++;
                }
                tmpSb.append('}');
                map.put(tmpSb.length(), tmpSb.toString());
            }else
                repeat++;
        }

        for(Integer key : map.keySet()){
            StringBuilder sb = new StringBuilder();
            String nowStr = map.get(key);
            for (int i = 0; i < nowStr.length(); i++) {
                if(Character.isDigit(nowStr.charAt(i))){
                    sb.append(nowStr.charAt(i));
                }else if(sb.length() != 0){
                    set.add(Integer.parseInt(sb.toString()));
                    sb.delete(0, sb.length());
                }
            }
        }

        int[] answer = new int[set.size()];
        int idx = 0;
        for(Integer in : set){
            answer[idx] = in;
            idx++;
        }
        return answer;
    }
}
