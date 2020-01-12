package BOJ.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Q_2217_rope {
    /*
    1 <= n <= 100000
    k개의 로프, 중량 w
    각각의 로프 무게 w/k
    input : 로프들의 갯수, 로프들이 들어올리는 각각의 무게
    output : 물체의 최대 중량
     */
    static Scanner input = new Scanner(System.in);
    static int ropeNum = 0;
    static int ropeArr[] = null;
    public static void main(String[] args){
        ropeNum = input.nextInt();
        ropeArr = new int[ropeNum];

        for(int i = 0; i < ropeNum; i++) {
            ropeArr[i] = input.nextInt();
        }

        Arrays.sort(ropeArr);

        System.out.println(caculWeight(ropeNum, ropeArr));

        input.close();
    }

    public static int caculWeight(int ropeNum, int[] ropeArr){
        int resultNum = ropeArr[0] * ropeNum;
        int cntNUM = ropeNum;

        for(int i = 1; i < ropeNum; i++){
            cntNUM--;
            int nowNum = ropeArr[i] * cntNUM;
            if(nowNum > resultNum) resultNum = nowNum;
        }

        return resultNum;
    }
}
