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

    public static String changeWord(String nowWord, String compareWord, int cnt){
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
            // 맨뒤가 U일 경우 nowWord 개별 단어 뒤부터 검색해서 U아닐숫자나올시에 그 자리에서 +1 한 글자로 변경 후 뒤에 U 모두 삭제 후 recursion
            if(nowWord.getChar(nowWord.length()-1) == U){
                for(int i = nowWord.length() - 2; i > 0; i--){
                    if(nowWord.getChar(i) != U){
                        int index = charList.indexOf(nowWord.getChar(i));
                        nowWord = nowWord.subString(0,i) + charList.get(index + 1);
                        
                        changeWord(nowWord, compareWord, cnt + 1);
                    }
                }
            }
            // 아니면 charList 맨뒷자리 다음꺼 넣기
            int index = charList.indexOf(nowWord.getChar(nowWord.length()-1));
            nowWord = nowWord.subString(0,nowWord.length()-1) + charList.get(index + 1);
            changeWord(nowWord, compareWord, cnt + 1);
        }
    }
}
