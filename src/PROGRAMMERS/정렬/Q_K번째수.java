package PROGRAMMERS.정렬;

import java.util.Arrays;

public class Q_K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        for(int i = 0; i < commands.length; i++) {
            System.out.println(solution(array, commands)[i]);
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = cacul(commands[i], array);
        }

        return answer;
    }

    public static int cacul(int[] command, int[] array) {
        int[] splitTmp = new int[command[1]-command[0]+1];
        int resultIndex = command[2];
        int index = 0;
        for(int i = command[0]-1; i <= command[1]-1; i++) {
            splitTmp[index] = array[i];
            index++;
        }
        Arrays.sort(splitTmp);

        return splitTmp[resultIndex - 1];
    }
}
