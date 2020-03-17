package PROGRAMMERS.BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_여행경로 {
    static String[] answer;
    static List<String[]> answers = new ArrayList<>();
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        // [ICN, JFK, HND, IAD]
        //String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        // ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
        //String[][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
        // ICN -> COO -> ICN -> BOO -> DOO
        System.out.println(solution(tickets));
    }

    public static String[] solution(String[][] tickets) {
        List<Integer> startList = new ArrayList<>();

        Arrays.sort(tickets, (o1, o2) -> {
            return CharSequence.compare(o1[1], o2[1]);
        });

        for (int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals("ICN")){
                startList.add(i);
            }
        }

        for(int k = 0; k < startList.size(); k++) {
            answer = new String[tickets.length+1];
            int[] visited = new int[tickets.length+1];
            int idx = startList.get(k);
            visited[startList.get(k)] = 1;
            answer[0] = "ICN";

            findByTicket(idx, tickets, visited, 0);

            int check = 0;
            for (int i = 0; i < visited.length; i++) {
                check += visited[i];
            }
            if(check == visited.length)
                answers.add(answer);
            else
                continue;
        }

        answer = answers.get(0);

        return answer;
    }

    public static void findByTicket(int tmp, String[][] tickets, int[] visited, int n) {
        while (n < tickets.length) {
            n++;
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[tmp][1].equals(tickets[i][0]) && visited[i] == 0) {
                    answer[n] = tickets[i][0];
                    visited[i] = 1;
                    tmp = i;
                    findByTicket(tmp, tickets, visited, n);
                }
            }
            if (n == tickets.length && visited[n] == 0) {
                answer[n] = tickets[tmp][1];
                visited[n] = 1;
                }
        }
    }
}
