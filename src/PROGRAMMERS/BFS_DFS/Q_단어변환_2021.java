package PROGRAMMERS.BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;

public class Q_단어변환_2021 {
    public static void main(String[] args) {
      
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"}; //4
        String begin = "hit";
        String target = "cog";
     
        /* String[] words = {"hot", "dot", "dog", "lot", "log"}; //1
        String begin = "hot";
        String target = "lot"; */

        System.out.println(solution(words, begin, target));
    }

    private static int solution(String[] words, String begin, String target){
        int answer = 0;

        // target이 word 안에 없을 때 return 0
        int cnt = 0;
        for(String s : words){
            if(!s.equals(target)){
                cnt++;
            }
        }
        if(cnt == words.length)
            return 0;

        // begin 글자에서 target 글자로 하나씩 바꿔보고 word에 있으면 그걸로 변환
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
        answer = recursion(wordList, begin, target, 0);

        return answer;
    }

    // visited[] 넣기
    private static int recursion(ArrayList<String> wordList, String compareWord, String target, int answer){ // void로 변경
        int cnt = 0;
        int resultCnt = 0;
        for(int i = 0; i < wordList.size(); i++){
            for(int j = 0; j < wordList.get(i).length(); j++){
                if(wordList.get(i).charAt(j) == compareWord.charAt(j)){
                    cnt++;
                }
                if(compareWord.charAt(j) == target.charAt(j)){
                    resultCnt++;
                }
            }
            if(resultCnt == target.length() - 1) 
                return answer; // result 전역으로 선언하고 result = answer한 후 return 으로 변경

            if(cnt == wordList.get(i).length() - 1){
                compareWord = wordList.get(i);
                wordList.remove(i);
                recursion(wordList, compareWord, target, answer++);
            }else if(cnt == wordList.get(i).length()){
                return answer;
            }else{
                cnt = 0;
                wordList.remove(i);
            }
        }
        return answer;
    }    
}
