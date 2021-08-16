package PROGRAMMERS.위클리문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 상호평가 {
    public static void main(String[] args) {
        int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        StringBuilder answer = new StringBuilder();

        int studentScore = 0;
        for(int i = 0; i < scores.length; i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0; j < scores.length; j++){
                tmp.add(scores[j][i]);
            }

            int selfScore = tmp.get(i);
            Collections.sort(tmp);
            if(selfScore == tmp.get(0) && tmp.get(0) != tmp.get(1)){
                tmp.remove(0);
            }else if(selfScore == tmp.get(tmp.size()-1) && tmp.get(tmp.size()-2) != tmp.get(tmp.size()-1)){
                tmp.remove(tmp.size()-1);
            }
            for(int score : tmp){
                studentScore += score;
            }
            studentScore = studentScore/tmp.size();
            answer.append(grade(studentScore));
            studentScore = 0;
        }

        System.out.println(answer); 
    }

    public static String grade(int score){
        if(score >= 90)
            return "A";
        else if(score >= 80 && score < 90)
            return "B";
        else if(score >= 70 && score < 80)
            return "C";
        else if(score >= 50 && score < 70)
            return "D";
        else if(score < 50)
            return "F";

        return null;
    }
}
