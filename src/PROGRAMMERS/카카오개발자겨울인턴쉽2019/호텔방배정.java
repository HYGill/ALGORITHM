package PROGRAMMERS.카카오개발자겨울인턴쉽2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 호텔방배정 {
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1,3,4,1,3,1};
        System.out.println(solution(k, room_number));
    }

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        HashMap<Long,Long> room = new HashMap();

        for(int i = 0; i < room_number.length; i++) {
            long nowNum = room_number[i];
            if(!room.containsKey(nowNum)) {
                answer[i] = nowNum;
                room.put(nowNum, nowNum+1);
            }
            else {
                List<Long> list = new ArrayList();
                while(room.containsKey(nowNum)) {
                    list.add(nowNum);
                    nowNum = room.get(nowNum);
                }
                answer[i] = nowNum;
                list.add(nowNum);
                for(long l : list) {
                    room.put(l, nowNum+1);
                }
            }
        }
        return answer;
    }
}
