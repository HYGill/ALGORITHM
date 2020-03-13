package PROGRAMMERS.스택_큐;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q_프린터 {
    public static void main(String[] args) {
        //int[] priorities = {2,1,3,2};
        //int[] priorities = {1, 1, 9, 1, 1, 1};
        int[] priorities = {2,2,2,1,3,4};
        //int location = 2;//1
        //int location = 0;//5
        int location = 3;//6

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : priorities){
            priorityQueue.offer(i);
        }

        while (!priorityQueue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorityQueue.peek() == priorities[i]) {
                    if (i == location) {
                        answer++;
                        return answer;
                    } else {
                        priorityQueue.poll();
                        answer++;
                    }
                }
            }
        }


        return answer;
    }
}
