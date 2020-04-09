package BOJ.Tree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q_1197_최소스패닝트리 {
    static Scanner input = new Scanner(System.in);
    static int[] parent;

    public static void main(String[] args) {
        int v = input.nextInt(); // 노드의 갯수
        int e = input.nextInt(); // 간선의 갯수
        int answer = 0;

        PriorityQueue<Dot> pq = new PriorityQueue<>(new Comparator<Dot>() {
            @Override
            public int compare(Dot o1, Dot o2) {
                return o1.value - o2.value;
            }
        });

        for (int i = 0; i < e; i++) {
            int tmp = input.nextInt();
            int tmp2 = input.nextInt();
            int tmp3 = input.nextInt();
            pq.offer(new Dot(tmp, tmp2, tmp3));
        }

        parent = new int[v+1];
        for (int i = 1; i <= v; i++) //정점은 1번부터 v번 까지 번호
            parent[i] = i;

        while (!pq.isEmpty()){
            Dot cur = pq.poll();
            int rootX = findRoot(cur.x);
            int rootY = findRoot(cur.y);

            if(rootX != rootY) { //union-find 중 union 함수, 연결되지 않은 그룹을 연결시켜준다.
                int x = findRoot(rootX);
                int y = findRoot(rootY);

                parent[y] = x;
                answer += cur.value;   //새로 연결된 간선의 가중치를 더해준다.
            }
        }

        System.out.print(answer);
    }

    static public int findRoot(int v) {
        if (v == parent[v])  //v node 의 값(==parent[v])이 v 랑 같다면 v는 root node
            return v;
        else {
            //v의 parent node 를 찾기 위해 parameter 로 parent[v]를 넘겨줌
            parent[v] = findRoot(parent[v]);
            return parent[v];
        }
    }
}

class Dot {
    int x, y, value;
    public Dot(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
