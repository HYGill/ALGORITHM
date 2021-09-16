package PROGRAMMERS.위클리문제;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class 입실퇴실 {
    private static List<Integer> leaveList = new ArrayList<>();
    public static void main(String[] args) {
        int[] enter = {1,3,2};
        int[] leave = {1,2,3};
        System.out.println(solution(enter, leave));
    }

    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = {};
        
        List<Integer> enterList = new ArrayList<Integer>();
        for(int i : enter) enterList.add(i);
        for(int i : leave) leaveList.add(i);
        
        List<Integer> room = new ArrayList<>();
        Map<Integer, Integer> meetCnt = new LinkedHashMap<>();

        while(enterList.size() > 0 && leaveList.size() > 0){
            int nowEnter = enterList.get(0);
            // enter가 room에 들어오고 enterList에서 제거
            room.add(enterList.get(0));
            enterList.remove(0);
            
            if(room.size() > 1){
                // 점수 계산. 새로 들어온사람은 기존 인원수 만큼 cnt증가
                for(Integer key : meetCnt.keySet()) {
                    int tmp = meetCnt.get(key);
                    if(key == nowEnter){
                        tmp += room.size()-1;
                    }else{
                        tmp++;
                    }
                    meetCnt.put(key, tmp);
                }
            }
            
            // room 떠날 사람 검사
            removeRecursion(room, leaveList.get(0));
        }

        int index = 0;
        for(Integer key : meetCnt.keySet()) {
            answer[index] = meetCnt.get(key);
        }
        return answer;
    }
    
    public static void removeRecursion(List<Integer> room, int removeNum){
        // leaveList.get(0)이 room에 있는지 확인
        // 같으면 room에서 빼고 leaveList에서도 빼기
        if(room.contains(removeNum)){
                int index = room.indexOf(removeNum);
                room.remove(index);
                leaveList.remove(0);
        }
        
        // 방을 떠날 수 있는 사람이 뒤에 있는지 확인
        if(room.contains(leaveList.get(0))){
           removeRecursion(room, leaveList.get(0));
        }
    }
}
