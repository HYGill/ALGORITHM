import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q_단어변환 {
   static int result = 0;

   public static void main(String[] args) {
      String[] words = {"hot", "dot", "hit", "lot", "log", "cog"};
      String begin = "hit";
      String target = "cog";
      System.out.println(solution(begin, target, words));
   }
   public static int solution(String begin, String target, String[] words) {
      int answer = 0;

      int c = 0;
      for(int k=0; k<words.length; k++){
         c = target.equals(words[k]) ? c+1 : c;
      }
      if(c == 0) {
         return 0;
      }

      answer = recursion(begin, target, words, answer);

      return answer;
   }
   
   public static int recursion(String begin, String target, String[] words, int answer){
      int m = 0;
      String tmpWord = "";
      String[] sArrays = new String[words.length - 1];
      
      for(String word : words){
         tmpWord = word;
         int cnt = 0;
         
         for(int i=0; i<begin.length(); i++){
            cnt = word.charAt(i) == begin.charAt(i) ? cnt +1 : cnt;
            m = word.charAt(i) == target.charAt(i) ? m+1 : m;
         }

         List<String> list = new ArrayList<String>();
         Collections.addAll(list, words);
         if(cnt == word.length()-1 && m != word.length()-1){
            begin = word;
            answer++;
            list.remove(word);
         }
         
         sArrays = list.toArray(new String[list.size()]);
         
         if(begin.equals(target)) {
            return answer;
         }
      }
      if(!tmpWord.equals(target) && sArrays.length > 0) {
         return recursion(begin, target, sArrays, answer);
      }
      return answer;
   }
}
