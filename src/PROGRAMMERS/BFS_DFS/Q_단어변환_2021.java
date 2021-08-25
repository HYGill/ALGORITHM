package PROGRAMMERS.BFS_DFS;

public class Q_단어변환_2021 {
    static int answer = 0;
    static boolean visited[];
    public static void main(String[] args) {
      
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"}; //4
        String begin = "hit";
        String target = "cog";
     
        System.out.println(solution(words, begin, target));
    }

    private static int solution(String[] words, String begin, String target){
        // target이 word 안에 없을 때 return 0
        int cnt = 0;
        for(String s : words){
            if(!s.equals(target)){
                cnt++;
            }
        }
        if(cnt == words.length)
            return 0;

        visited = new boolean[words.length];
        recursion(words, begin, target, 0);

        return answer;
    }

    private static void recursion(String[] words, String compareWord, String target, int result){
        if(compareWord.equals(target)){
            answer = result;
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(!visited[i]){
                int cnt = 0;
                for(int j = 0; j < words[i].length(); j++){
                    if(words[i].charAt(j) == compareWord.charAt(j)){
                        cnt++;
                    }
                }
                if(cnt == words[i].length() - 1){
                    visited[i] = true;
                    recursion(words, words[i], target, result+1);
                    visited[i] = false;
                }
            }
        }
    }
}