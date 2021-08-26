package PROGRAMMERS.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Q_여행경로_2021 {
    public static void main(String[] args) {
      
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}; 
     
        System.out.println(solution(tickets));
    }

    private static String[] solution(String[][] tickets){
        String[] answer = {};
        String start = "ICN";

        bfs(start, tickets);

        return answer;
    }

    private static void bfs(String start, String[][] tickets){
        Queue<String> q = queueSetting(start, tickets);
        boolean[] visited = new boolean[tickets.length];

        // 알파벳순으로 앞서는 로직 추가
        // q.polll 후 이 전것보다 알파벳이 앞에 있을 시 visited 표시 후 넘어감

    }

    private static Queue<String> queueSetting(String start, String[][] tickets){
        Queue<String> q = new LinkedList<>();
        // start으로 시작하는 배열들의 뒷자리를 모두 Queue에 추가
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i][0].equals(start)){
                q.offer(tickets[i][1]);
            }
        }

        return q;
    }
}
