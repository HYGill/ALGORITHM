public class 피로도 {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        
        solution(k, dungeons);
    }
    
    public static int solution(int k, int[][] dungeons) {
        int answer = 0;
        boolean[] visited = new boolean[dungeons.length];
        
        // dfs
        dfs(dungeons, k, answer);
        
        return answer;
    }
    
    public static void dfs(int[][] dungeons, int nowPotion, int cnt){
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i]){
                visited[i] = true
                dfs(dungeons, nowPotion-dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
}
