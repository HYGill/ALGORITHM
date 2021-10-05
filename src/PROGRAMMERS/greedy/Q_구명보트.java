
import java.util.ArrayList;
import java.util.Arrays;

public class Q_구명보트 {
    static int answer = 0;
    public static void main(String[] args) {
        int[] people = {70, 60, 80};
        int limit = 100;

        solution(people, limit);

        System.out.println(answer);
    }

    static public int solution(int[] people, int limit) {
        Arrays.sort(people);
        ArrayList<Integer> arrNum = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            arrNum.add(people[i]);
        }

        while (arrNum.size() > 0){
            if((arrNum.size() - 1) == 0){
                answer++;
                return answer;
            }
            if(arrNum.get(0) + arrNum.get(arrNum.size() - 1) > limit){
                answer++;
                arrNum.remove(arrNum.size() - 1);
            }else{
                answer++;
                arrNum.remove(0);
                if(arrNum.size() > 0)
                    arrNum.remove(arrNum.size() - 1);
            }
        }

        return answer;
    }
}
