package PROGRAMMERS.BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class Q_단어변환 {
   static int answer = 0;

   public static void main(String[] args) {
      String[] words = {"hot", "dot", "hit", "lot", "log", "cog"}; //4
      //String[] words = {"hot", "dot", "dog", "lot", "log"}; //0
      String begin = "hit";
      String target = "cog";
      System.out.println(solution(begin, target, words));
   }
   public static int solution(String begin, String target, String[] words) {
      List<String> wordList = new ArrayList<>();
      for (String s : words)
         wordList.add(s);

      if(wordList.contains(target)){
         wordList.remove(begin);
         recursion(begin, target, wordList);
      }else
         return 0;

      return answer-1;
   }

   // [hot,dot,dog,lot,log,cog]라면 hit -> hot -> dot -> dog -> cog와 같이 4단계를 거쳐 변환할 수 있습니다.
   public static void recursion(String begin, String target, List<String> wordList){
      int idx = 0;
      while (!wordList.isEmpty()){
         int sameChk = 0;
         String nowWord = wordList.get(idx);
         for (int i = 0; i < nowWord.length(); i++) {
            if(nowWord.charAt(i) == begin.charAt(i))
               sameChk++;
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
