package javaTest;


public class Q_타겟넘버 {
   private static int answer = 0;
   public static void main(String[] args) {
      int[] numbers = {1, 1, 1, 1, 1};
      int target = 3;
      System.out.println(solution(numbers, target));
   }

   public static int solution(int[] numbers, int target) {
      dfs(target, numbers, 0);
      return answer;
   }

   public static void dfs(int target, int[] num, int k) {
      if(k == num.length) {
         int sum = 0;
         for(int i = 0; i < num.length; i++) {
            sum = sum + num[i];
         }
         if(sum == target) {
            answer++;
         }
         return;
      } else {
         num[k] = num[k] * 1;
         dfs(target, num, k + 1);

         num[k] = num[k] * -1;
         dfs(target, num, k + 1);
      }
   }
}
