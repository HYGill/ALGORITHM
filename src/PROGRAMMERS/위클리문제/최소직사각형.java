package PROGRAMMERS.위클리문제;

public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        
        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int answer = 0;

        int originBig = (sizes[0][0] >= sizes[0][1]) ? sizes[0][0] : sizes[0][1];
        int originSmall = (sizes[0][0] <= sizes[0][1]) ? sizes[0][0] : sizes[0][1];
        for(int i = 1; i < sizes.length; i++){
            int bigSize = (sizes[i][0] >= sizes[i][1]) ? sizes[i][0] : sizes[i][1];
            int smallSize = (sizes[i][0] <= sizes[i][1]) ? sizes[i][0] : sizes[i][1];
 
            if(bigSize > originBig){
                originBig = bigSize;
            }

            if(smallSize > originSmall){
                originSmall = smallSize;
            }
        }
        
        return originBig * originSmall;
    }
}
