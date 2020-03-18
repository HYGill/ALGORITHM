package PROGRAMMERS.BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class Q_단어변환 {
   static int answer = 0;

   public static void main(String[] args) {
      /*
      String[] words = {"hot", "dot", "dog", "lot", "log", "cog"}; //4
      String begin = "hit";
      String target = "cog";
      */
      String[] words = {"hot", "dot", "dog", "lot", "log"}; //1
      String begin = "hot";
      String target = "lot";

      System.out.println(solution(begin, target, words));
   }
   public static int solution(String begin, String target, String[] words) {
      int tmp = 0;
      for (int i = 0; i < begin.length(); i++) {
         if(begin.charAt(i) == target.charAt(i))
            tmp++;
      }

      List<String> wordList = new ArrayList<>();
      for (String s : words)
         wordList.add(s);

      if(wordList.contains(target)){
         answer++;
         if(tmp >= begin.length()-1)
            return 1;
         else {
            wordList.remove(begin);
            recursion(begin, target, wordList);
         }
      }else
         return 0;

      return answer;
   }

   public static void recursion(String begin, String target, List<String> wordList){
      int idx = 0;
      while (!wordList.isEmpty()){
         int sameChk = 0;
         int targetChk = 0;
         String nowWord = wordList.get(idx);
         for (int i = 0; i < nowWord.length(); i++) {
            if(nowWord.charAt(i) == begin.charAt(i))
               sameChk++;
            if(target.charAt(i) == nowWord.charAt(i))
               targetChk++;
         }
         if(targetChk == nowWord.length() - 1){
            wordList.clear();
            answer++;
            break;
         }
         if(sameChk >= nowWord.length() - 1){
            wordList.remove(nowWord);
            answer++;
            recursion(nowWord, target, wordList);
         }else if(sameChk == nowWord.length() && wordList.size() == 1){
            wordList.remove(nowWord);
         }else{
            idx++;
            continue;
         }
      }
   }
}
