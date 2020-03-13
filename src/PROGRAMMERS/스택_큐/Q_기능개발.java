package PROGRAMMERS.스택_큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q_기능개발 {
    public static void main(String[] args) {
//        int [] progresses = {93,30,55};
       int [] progresses = {93,30,55,60};
        //int [] progresses = {93, 30, 55, 60, 40, 60, 65};
        //int [] progresses = {40, 93, 30, 55, 60, 65};
//        int[] speeds = {1,30,5}; //[2,1]
        int[] speeds = {1,30,5,40}; //[2,2]
        //int[] speeds = {1, 30, 5 , 10, 60, 10, 7};//[2,5]
        //int[] speeds = {60, 1, 30, 5 , 10, 7};//[1,2,3]

        System.out.println(solution(progresses, speeds));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        Queue<work> works = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            works.add(new work(progresses[i], speeds[i]));
        }

        while (!works.isEmpty()) {
            int nowProgress = works.peek().progress;
            int cnt = 0;
            while (nowProgress < 100){
                nowProgress += works.peek().speed;
                cnt++;

                if(nowProgress >= 100){
                    queue.offer(cnt);
                    works.poll();
                }
            }
        }

        int max = queue.poll();
        int day = 1;
        while (true){
            if(max < queue.peek()){
                max = queue.poll();
                result.add(day);
                day = 1;
            }else {
                day++;
                queue.poll();
            }

            if(queue.isEmpty()){
                result.add(day);
                break;
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
            System.out.print(answer[i]);
        }

        return answer;
    }

    static class work {
        int progress;
        int speed;

        public work(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }
}
