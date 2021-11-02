public class 교점에별만들기 {
    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        
        System.out.println(solution(line));
    }

    public static String[] solution(int[][] line) {
        String[] answer = {};

        

        return answer;
    }

    public static int[] cacul(int a, int b, int c, int d, int f, int e){
        if((a*d - b*c) == 0){
            return null;
        }

        int x = (b*f - e*d)/(a*d - b*c);
        int y = (e*c - a*f)/(a*d - b*c);
        int[] arr = {x,y};

        return arr;
    }
}
