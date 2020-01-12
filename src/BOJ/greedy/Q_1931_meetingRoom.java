package BOJ.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q_1931_meetingRoom {
    /*
    input : 회의실 갯수
            시작시간 끝나는 시간
    output : 최대 사용할 수 있는 회의 수
     */
    static Scanner input = new Scanner(System.in);
    static int n;
    static int arr[][];

    public static void main(String[] args){
        n = input.nextInt();

        arr = new int[n][2];
        // data 받기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                arr[i][j] = input.nextInt();
            }
        }

        // 정렬을 위한 기준을 적는다.
        // 끝나는 시간이 빨라야 최대한 회의 받을 수 있다.
        // 정렬 앞에오고싶을때는 음수 같을때는 0
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] compare1, int[] compare2) {
                // 끝나는 시간이 똑같으면
                if(compare1[1] == compare2[1]) {
                    // 시작하는 시간이 짧은 것부터 정렬(음수)
                    return compare1[0] - compare2[0];
                }
                else
                    // 끝나는 시간이 빠른 것 부터 정렬
                    return compare1[1] - compare2[1];
            }
        });


        System.out.println(solve());
    }

    static int solve(){
        int first = 0;
        int cnt = 1;

        // 정렬한 것 중에 시작하는 시간이 기준의 끝나는 시간보다 짧은 것 out
        for(int i = 1; i < n; i++) {
            if(arr[i][0] < arr[first][1])
                continue;

            cnt++;
            first = i;
        }
        return cnt;
    }
}
