package PROGRAMMERS.스택_큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q_기능개발 {
    public static void main(String[] args) {
        //int [] progresses = {93,30,55};
        //int [] progresses = {93,30,55,60};
        int [] progresses = {93, 30, 55, 60, 40, 60, 65};
        //int [] progresses = {40, 93, 30, 55, 60, 65};
        //int[] speeds = {1,30,5}; //[2,1]
        //int[] speeds = {1,30,5,40}; //[2,2]
        int[] speeds = {1, 30, 5 , 10, 60, 10, 7};//[2,5]
        //int[] speeds = {60, 1, 30, 5 , 10, 7};//[1,2,3]

        System.out.println(solution(progresses, speeds));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> tmp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

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
                    tmp.add(cnt);
                    works.poll();
                }
            }
        }

        int index = 0;
        do{
            int cnt = 1;
            int tmpVal = index+1 >= tmp.size() ? 10 : tmp.get(index+1);
            if(tmp.get(index) < tmpVal){
                result.add(cnt);
                index++;
            }else {
                for (int j = index+2; j < tmp.size(); j++) {
                    cnt++;
                    if(tmp.get(index) < tmp.get(j)) {
                        result.add(cnt);
                        index = j;
                        break;
                    }else{
                        if(j == tmp.size()-1) {
                            cnt++;
                            index = j+1;
                            result.add(cnt);
                            break;
                        }
                        else{
                            index = j+1;
                            continue;
                        }
                    }
                }
            }
        }
        while (index < tmp.size());

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
            System.out.println(answer[i]);
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
