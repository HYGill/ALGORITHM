public class 부족한금액계산하기 {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        long answer = 0;

        long result = 0;
        for(int i = 1; i <= count; i++){
            result += (price * i);
        }

        answer = result - money;

        System.out.println(answer); 
    }
}
