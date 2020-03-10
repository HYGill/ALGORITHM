package PROGRAMMERS.스택_큐;

import java.util.LinkedList;
import java.util.Queue;

public class Q_다리를지나는트럭 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        //대기 트럭
        Queue<Truck> waitTruck = new LinkedList<>();

        //다리를 건너는 트럭
        Queue<Truck> ingTruck = new LinkedList<>();

        int onBridgeWeight = 0;

        for (int w : truck_weights) {
            waitTruck.add(new Truck(w, 0)); // 대기 트럭에 우선 다 넣어둔다.
        }

        /*
        보관할 때 offer
        가장 먼저 보관한 자료를 꺼낼 때는 poll
        가장 먼저 보관한 자료를 단순 참조하는 peek
        비었는지 판별하는 empty
         */

        onBridgeWeight += waitTruck.peek().weight;
        ingTruck.add(waitTruck.poll());

        while (!ingTruck.isEmpty()) {
            answer++;

            for (Truck t : ingTruck) {
                t.distance++; // 트럭들이 움직임
            }

            // distance 가 다리보다 길면 도착
            if (ingTruck.peek().distance > bridge_length) {
                onBridgeWeight -= ingTruck.poll().weight;
            }

            //대기 중 트럭을 다리에 올린다, 다음거 올릴 무게 안되면 진행 안됨
            if (!waitTruck.isEmpty() && waitTruck.peek().weight + onBridgeWeight <= weight) {
                onBridgeWeight += waitTruck.peek().weight;
                waitTruck.peek().distance++;
                ingTruck.add(waitTruck.poll());
            }
        }

        return answer;
    }

    static class Truck {
        int weight;
        int distance;

        public Truck(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }
    }
}