package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2875_대회or인턴 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        /*
         * input : 여학생, 남학생, 인턴참가인원
         * output : 만들 수 있는 팀 수
         * 팀에는 여학생 2명 남학생 1명이 들어가야한다.
         */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int k = Integer.parseInt(str[2]);

        int tmp = n/2 > m ? m : n/2;

        int cnt = 0;
        for(int i = 1; i <= tmp; i++) {
            if(k <= (n + m)-(2*i + i)) cnt++;
            else break;
        }

        System.out.println(cnt);
    }

}
