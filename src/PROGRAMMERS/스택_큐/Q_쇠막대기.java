package PROGRAMMERS.스택_큐;

import java.util.Stack;

public class Q_쇠막대기 {
    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";

        System.out.println(solution(arrangement));
    }

    public static int solution(String arrangement) {
        int answer = 0;

        char[] laser = new char[arrangement.length()];
        for (int i = 0; i < arrangement.length(); i++) {
            laser[i] = arrangement.charAt(i);
        }
        Stack<Character> nowLaser = new Stack<>();

        for (int i = 0; i < laser.length; i++) {
            int tmpIndex = i >= 1 ? i-1 : 0;
            int tmp = laser[tmpIndex];

            if(laser[i]=='('){
                nowLaser.push(laser[i]);
            }else if(laser[i]==')' && tmp == '(' && nowLaser.size() >= 1) {
                answer += nowLaser.size() - 1;
                nowLaser.pop();
            }else if(laser[i]==')' && tmp == ')' && nowLaser.size() >= 1){
                answer += 1;
                nowLaser.pop();
            }else{
                nowLaser.pop();
            }
        }
        return answer;
    }
}
