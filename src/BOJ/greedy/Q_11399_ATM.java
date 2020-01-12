package BOJ.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Q_11399_ATM {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n = input.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr);

        int total = arr[0];
        for(int i = 1; i < n; i++){
            arr[i] += arr[i-1];
            total += arr[i];
        }
        System.out.println(total);
    }
}
