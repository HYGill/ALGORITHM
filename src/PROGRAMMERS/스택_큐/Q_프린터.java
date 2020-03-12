package PROGRAMMERS.스택_큐;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Q_프린터 {
    public static void main(String[] args) {
        //int[] priorities = {2,1,3,2};
        int[] priorities = {1, 1, 9, 1, 1, 1};
        //int[] priorities = {2,2,2,1,3,4};
        //int location = 2;//1
        int location = 0;//5
        //int location = 3;//6

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> prioritiesList = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            prioritiesList.add(priorities[i]);
        }

        List<printInfo> printInfos = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            printInfos.add(new printInfo(i, priorities[i]));
        }

        prioritiesList.sort(Comparator.reverseOrder()); // max구하기 위함
        while (printInfos.size() > 0) {
            for (int i = 0; i < printInfos.size(); i++) {
                int max = prioritiesList.get(0);
                int index = FindIndex(printInfos, max); // max인 index구하기
                if(printInfos.get(0).priority != max) { // max 값까지 갈때까지 앞에꺼 다 뒤로 보내기
                    for (int j = 0; j < index; j++) {
                        printInfo tmp = printInfos.get(0);
                        printInfos.remove(0);
                        printInfos.add(tmp);
                    }
                }else{// max가 맨앞에 있으면
                    if(printInfos.get(0).index == location){
                        answer++;
                        return answer;
                    }else {
                        prioritiesList.remove(0);
                        printInfos.remove(0);
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static int FindIndex(List<printInfo> printInfos, int max){
        int index = 0;
        for (int i = 0; i < printInfos.size(); i++) {
            if(printInfos.get(i).priority == max)
                index = i;
        }
        return index;
    }

    static class printInfo{
        int index;
        int priority;

        public printInfo(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
