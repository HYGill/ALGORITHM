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

        // 괄호안에 숫자가 적은 숫자대로 map에 넣었다. 왜냐하면 적게 들어간 것 부터 답을 넣어야하기 때문
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

        //3:{2}, 5:{2,1}, 7:{1,2,3}. 9:{1,2,4,3} 으로 map 생성
        //첫번쨰꺼부터 돌면서 표현하는 tuple에 삽입. 중복된 수가 없게하려고 set사용
        for(Integer key : map.keySet()){
            //두자리수가 있을 수 있으므로 sb사용해서 한글자씩 붙인다
            StringBuilder sb = new StringBuilder();
            String nowStr = map.get(key);
            for (int i = 0; i < nowStr.length(); i++) {
                // 숫자이면
                if(Character.isDigit(nowStr.charAt(i))){
                    // 붙여라
                    sb.append(nowStr.charAt(i));
                }else if(sb.length() != 0){
                    // 숫자가 아니라면 이제까지 set에 넣고 초기화
                    set.add(Integer.parseInt(sb.toString()));
                    sb.delete(0, sb.length());
                }
            }
        }

        // answer에 set에 있는값 넣기
        int[] answer = new int[set.size()];
        int idx = 0;
        for(Integer in : set){
            answer[idx] = in;
            idx++;
        }
        return answer;
    }
}
