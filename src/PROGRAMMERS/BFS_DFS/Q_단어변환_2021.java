package PROGRAMMERS.BFS_DFS;

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

    public static int solution(String[] words, String begin, String target){
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
        

        return answer;
    }

    
}
