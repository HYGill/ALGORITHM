package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1700_멀티탭스케쥴링 {
    public static void main(String[] args) throws NumberFormatException, IOException {
      /*
          input : 멀티탭 구멍 수, 가전제품개수
                  가전제품고유의 숫자
          output : 갈아끼는 숫자

          고려해야할 것
          1. 빈칸이 있으면 그냥 꽂으면 된다.
          2. 빈칸이 없을 시에 같은 것이 있나 검사
          3. 검사할 때 이후에 나올 것이 있나도 검사해야한다.
       */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]); // 2
        int m = Integer.parseInt(str[1]); // 7
        String[] input = bf.readLine().split(" ");

        int[] multi = new int[n];
        int[] arr = new int[m];
        for (int i = 0; i < m; i++){
            arr[i] = Integer.parseInt(input[i]); // 2 3 2 3 1 2 7
        }

        for(int i = 0; i < n; i++){
            multi[i] = arr[i]; // 2 3
        }

        int result = 0;
        for(int i = 0; i < m; i++) {
            boolean isUse = false;
            for(int j = 0; j < n; j++) {
                if(multi[j] == arr[i]) {
                    isUse = true;
                    break;
                }
            }

            if(isUse) continue;

            int swap = -1, val = -1;
            for(int j = 0; j < n; j++){
                int term = 0;
                for(int k = i + 1; k < m && multi[j] != arr[k]; k++)
                    term++;
                if(term > val){
                    swap = j;
                    val = term;
                }
            }
            result++;
            multi[swap] = arr[i];
        }

        System.out.println(result);
    }
}