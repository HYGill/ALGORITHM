package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q_1541_잃어버린괄호 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bf.readLine().split("-"); // - 연산자 기준으로 자름

        List<Integer> sumList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            sumList.add(sumNum(arr[i]));
        }

        int result = sumList.get(0);
        for (int i = 1; i < sumList.size(); i++) {
            result -= sumList.get(i);
        }

        System.out.println(result);
    }

    public static int sumNum(String arr) {
        // - 연산자 기준으로 자른 덩어리들이 들어옴
        // 덩어리들을 + 기준으로 자름
        int tmp = 0;
        String[] numArr = arr.split("[^0-9]");
        for (int i = 0; i < numArr.length; i++) {
            tmp += Integer.parseInt(numArr[i]);
        }

        return tmp;
    }
}
