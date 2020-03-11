package PROGRAMMERS.스택_큐;

public class Q_주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(solution(prices)); //4, 3, 1, 1, 0
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j-i;
                    break;
                }
                if (j == prices.length - 1)
                    answer[i] = j-i;
            }
        }
        return answer;
    }
}
