package PROGRAMMERS.해시;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

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
        HashSet hashSet = new HashSet(Arrays.asList(completion));
        HashSet isSameName = new HashSet(Arrays.asList(participant));
        int hashSize = hashSet.size();

        if(isSameName.size() == participant.length){
            for(String s : participant){
                hashSet.add(s);
                if(hashSize != hashSet.size()){
                    answer = s;
                    break;
                }
            }
        }else{
            ArrayList<String> tmp = new ArrayList<>(Arrays.asList(participant));
            for(String s : completion){
                if(tmp.contains(s)){
                    tmp.remove(s);
                }
            }
            answer = tmp.get(0);
        }

        return answer;
    }
}
