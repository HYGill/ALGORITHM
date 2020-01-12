package BOJ.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Q_1049_guitarString {
    /*
    input : 필요한 기타줄 개수 n, 기타줄 브랜드 m(몇번 받을것인가)
            패키지가격, 낱개의 가
    output : 필요한 돈의 최솟격
    */
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        /*
         * 처음에 패키지 + 낱개 되는줄 모르고 sort가 불필요한줄알아서 2차원배열로 입력받았다.
         */
        int n = input.nextInt();
        int m = input.nextInt();

        int[] each = new int[m];
        int[] pack = new int[m];

        for(int i = 0; i < m; i++) {
            pack[i] = input.nextInt();
            each[i] = input.nextInt();
        }

        Arrays.sort(pack);
        Arrays.sort(each);

        int result = 0;
        int divi = n % 6;

        if(n < 6) {
            if (pack[0] < each[0] * 6) result = (n / 6 + 1) * pack[0];
            else result = each[0] * (n / 6 + 1) * 6;
        }else {
            if (pack[0] < each[0] * 6) result = (n / 6) * pack[0];
            else result = each[0] * (n / 6) * 6;

            if (pack[0] < (divi * each[0])) result = result + pack[0];
            else result = result + (divi * each[0]);
        }

        System.out.println(result);
    }
}
