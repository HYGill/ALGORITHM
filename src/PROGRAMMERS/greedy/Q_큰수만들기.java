package PROGRAMMERS.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class Q_큰수만들기 {
    static String answer = null;
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;

        System.out.println(solution(number, k));
    }

    static public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arrNum = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            int tmp = Character.getNumericValue(number.charAt(i));
            arrNum.add(tmp);
        }

        ArrayList<Integer> tmp2 = arrNum;

        int answerNum = arrNum.size()-k;
        int[] result = new int[answerNum];
        int n = 0;

        while(answerNum > 0){
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < tmp2.size() - answerNum + 1; i++) {
                tmp.add(arrNum.get(i));
            }

            int removeSize = 0;
            while(removeSize <= tmp2.size() - answerNum + 1){
                arrNum.remove(0);
                removeSize++;
            }

            Collections.sort(tmp);
            result[n] = tmp.get(tmp.size()-1);
            n++;

            answerNum--;

            if(result.length == n)
                break;
        }

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        answer = sb.toString();

        return answer;
    }
}
