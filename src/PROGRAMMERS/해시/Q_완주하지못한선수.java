package PROGRAMMERS.해시;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Q_완주하지못한선수 {
    static String answer = "";
    public static void main(String[] args) {
        //String[] participant = {"leo", "kiki", "eden"};
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        //String[] completion = {"eden", "kiki"};
        String[] completion = {"stanko", "ana", "mislav"};

        solution(participant, completion);

        System.out.println(answer);
    }

    static public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            participantMap.put(participant[i], participantMap.getOrDefault(participant[i], 0)+1);
        }

        for (int i = 0; i < completion.length; i++) {
            participantMap.put(completion[i], participantMap.getOrDefault(completion[i], 0)-1);
        }

        Set<String> keySet = participantMap.keySet();
        for(String key : keySet) {
            if(participantMap.get(key) != 0)
                answer = key;
        }

        return answer;
    }
}
