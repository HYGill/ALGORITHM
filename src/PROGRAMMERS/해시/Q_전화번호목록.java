package PROGRAMMERS.해시;

import java.util.Arrays;

public class Q_전화번호목록 {
    static Boolean answer = true;
    public static void main(String[] args) {
        // String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book = {"123","456","789"};

        solution(phone_book);

        System.out.println(answer);
    }

    static public Boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0 ; i < phone_book.length-1; i++){
            if (phone_book[i+1].startsWith(phone_book[i]))
                return false;
        }

        return answer;
    }
}
