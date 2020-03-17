package PROGRAMMERS.BFS_DFS;

public class Q_타겟넘버 {
   private static int answer = 0;
   public static void main(String[] args) {
      int[] numbers = {1, 1, 1, 1, 1}; // 5
      int target = 3;
      System.out.println(solution(numbers, target));
   }

   public static int solution(int[] numbers, int target) {
      recursion(numbers, target, 0);

      return answer;
   }

   public static void recursion(int[] numbers, int target, int cnt){
      if(cnt == numbers.length){
         int sum = 0;
         for(int i : numbers){
            sum += i;
         }
         if(sum == target) {
            answer++;
         }
         return;
      }else {
         numbers[cnt] = numbers[cnt] * 1;
         recursion(numbers, target, cnt + 1);

         numbers[cnt] = numbers[cnt] * -1;
         recursion(numbers, target, cnt + 1);
      }
   }
}
