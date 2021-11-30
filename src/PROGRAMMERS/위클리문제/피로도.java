public class 피로도 {
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        
        System.out.println(solution(k, dungeons));
    }
    
    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, answer);
        
        return answer;
    }
    
    public static void dfs(int[][] dungeons, int nowPotion, int cnt){
        for(int i = 0; i < dungeons.length; i++){
            if(cnt > answer)
                answer = cnt;
            if(!visited[i]){
                visited[i] = true;
                      
                if(nowPotion >= dungeons[i][0]){
                    dfs(dungeons, nowPotion-dungeons[i][1], cnt+1);
                }
                visited[i] = false;
            }
        }
    }
}
