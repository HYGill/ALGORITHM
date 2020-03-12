package PROGRAMMERS.greedy;

public class Q_큰수만들기 {
    static String answer = null;
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;

        System.out.println(solution(number, k)); //775841
    }

    static public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int answerNum = number.length() - k; // 몇자리수를 만들어야하는지
        int in = 0;
        int start = 0;
        int i = 0;
        while(in != number.length() - k){
            Boolean flag = false;
            char tmp = number.charAt(start);
            for (i = start; i < number.length() - answerNum; i++) {
                if(tmp < number.charAt(i+1)){
                    tmp = number.charAt(i+1);
                    start = i+2;
                    flag = true;
                }
            }
            if(!flag)
                start++;

            sb.append(tmp);
            in++;
            answerNum--;
        }

        answer = sb.toString();

        return answer;
    }
}
