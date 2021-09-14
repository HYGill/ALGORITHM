package PROGRAMMERS.위클리문제;

public class 입실퇴실 {
    public static void main(String[] args) {
        int[] enter = {1,3,2};
        int[] leave = {1,2,3};
        System.out.println(solution(enter, leave));
    }

    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = {};
        
        List<Integer> enterList = Arrays.asList(enter);
        List<Integer> leaveList = Arrays.asList(leave);
        List<Integer> room = new ArrayList<>();
        Map<Integer, Integer> meetCnt = new LinkedHashMap<>();

        while(enterList.size() > 0 && leaveList.size() > 0 && room.size() > 0){
            // enter가 room에 들어오고 enterList에서 제거
            room.add(enterList.get(0));
            enterList.remove(0);
            
            // 점수 계산
            for(int i : room){
                int tmp = meetCnt.get(i);
                tmp++;
                meetCnt.put(i, tmp);
            }
            
            // leaveList.get(0) 과 같은지 비교
            // 같으면 room에서 빼고 leaveList에서도 빼기
            if(room.get(0) == leaveList.get(0)){
                room.remove(0);
                leaveList.remove(0);
            }
        }

        int index = 0;
        for(Integer key : map.keySet()) {
            answer[index] = map.get(key);
        }
        return answer;
    }
}
