package PROGRAMMERS.위클리문제;

public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        
        System.out.println(solution(sizes));
    }

    static public int solution(int[][] sizes) {
        answer = sizes[0][0] + sizes[0][1];
        
        return answer;
    }

    static int answer = 0;
    static public void recursion(int[][] sizes, int x, int y){
        for(int i = 1; i < sizes.length; i++){
            int compareX = 0;
            int compareY = 0;
            if(sizes[i][0] > sizes[i-1][0]){
                compareX = sizes[i][0];
            }
            if(sizes[i][1] > sizes[i-1][1]){
                compareY = sizes[i][1];
            }

            
        }
    }
}
