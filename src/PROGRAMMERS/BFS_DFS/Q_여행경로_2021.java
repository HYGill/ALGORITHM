package PROGRAMMERS.BFS_DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q_여행경로_2021 {
    private static boolean[] visited;
    private static List<String> answers;

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}; 

        visited = new boolean[tickets.length];    
        answers = new ArrayList<String>();
        int count = 0;
        dfs(count, "ICN", "ICN",tickets);                
        Collections.sort(answers);

        String[] answer = answers.get(0).split(",");

    }

    static public void dfs(int count, String nowAirport, String answer, String[][]ticktes) {
        if(count == ticktes.length) {
            answers.add(answer);
            return;
        }

        for(int i = 0; i < ticktes.length; i++) {
            if(!visited[i] && ticktes[i][0].equals(nowAirport)) {
                visited[i] = true;
                dfs(count+1, ticktes[i][1],answer+","+ticktes[i][1] , ticktes);
                visited[i] = false;
            }
        }
        return;
    }
}
