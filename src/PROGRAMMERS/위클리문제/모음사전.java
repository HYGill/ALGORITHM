package PROGRAMMERS.위클리문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모음사전 {
    List<String> charList = new ArrayList<>(Arrays.asList(new String[]{"A", "E", "I", "O", "U"}));
    public static void main(String[] args) {
        String word = "AAAAE";
        System.out.println(solution(word));
    }

    public static int solution(String word) {
        int answer = 0;

        return answer;
    }

    public static void changeWord(String nowWord, String compareWord, int cnt){
        /*
        * 만일 5글자가 아니면 A 채우기
        * 5글자면 U가 아닌 부분 글자바꾸기
        * U 면 앞자리꺼 U의 뒤에꺼로 바꿔주기
        */
        if(nowWord.equals(compareWord)){
            return;
        }

        if(nowWord.length() < 5){
            while(nowWord.length() == 5){
                nowWord += 'A';
            }
            changeWord(nowWord, compareWord, cnt + 1);
        }else{
            
        }
    }
}
