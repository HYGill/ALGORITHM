
public class Q_타겟넘버 {
   private static int answer = 0;
   public static void main(String[] args) {
      int[] numbers = {1, 1, 1, 1, 1}; // 5
      int target = 3;
      System.out.println(solution(numbers, target));
   }

   public static int solution(int[] numbers, int target) {
      recursion(numbers, target, 0, 0);

      return answer;
   }

   public static void recursion(int[] numbers, int target, int depth, int nowSum){
      if(depth == numbers.length){
         if(nowSum == target){
            answer++;
         }
      }else{
         recursion(numbers, target, depth+1, nowSum+numbers[depth]);
         recursion(numbers, target, depth+1, nowSum-numbers[depth]);
      }
   }
}
