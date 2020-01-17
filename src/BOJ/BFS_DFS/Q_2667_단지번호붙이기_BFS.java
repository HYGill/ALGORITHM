package BOJ.BFS_DFS;

import java.awt.*;
import java.util.Queue;
import java.util.*;

public class Q_2667_단지번호붙이기_BFS {
    /*
    input : 입력받을 n*n
    output : 단지개수, 단지의 수 오름차 정렬
     */
    static Queue<Point> q = new LinkedList<>();
    static int[][] map;
    static int[][] visited;
    // 위쪽은 (x-1, y). 아랫쪽은 (x+1, y)이고, 왼쪽은 (x, y-1), 오른쪽은 (x, y+1)
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static ArrayList al = new ArrayList();
    static int N;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        map = new int[N][N];
        visited = new int[N][N];
        String temp;

        for(int i = 0; i < N; i++) {
            temp = scan.next();
            for(int j = 0; j < N; j++)
                map[i][j] = temp.charAt(j)-'0';
        }

        // 2차원 배열 돌면서 1이고 방문하지 않았던것을 찾으면 BFS 호출
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                if(map[i][j] == 1 && visited[i][j] == 0) {
                    BFS(i, j);
                }

        System.out.println(al.size());

        Collections.sort(al);
        for(int i=0; i < al.size(); i++)
            System.out.println(al.get(i));
    }

    static void BFS(int i, int j) {
        int goX, goY;
        int local_cnt = 1;
        q.offer(new Point(i, j)); // offer은 넣는 것, 지금 1인 인자를 q에 넣어준다.
        visited[i][j] = 1;

        while(q.isEmpty() == false)
        {
            Point now;
            now = q.poll(); // 넣은 값 꺼내기

            for(int h = 0; h < 4; h++) {
                goX = now.x + dx[h];
                goY = now.y + dy[h];

                // 범위 값에 있다
                if(goX >= 0 && goY >= 0 && goX < N && goY < N) {
                    // 값이 1인데 방문하지 않았다
                    if(map[goX][goY] == 1 && visited[goX][goY]==0) {
                        // q에 삽입
                        q.offer(new Point(goX, goY));
                        // 방문 표시
                        visited[goX][goY] = 1;
                        // 단지숫자값 갱신
                        local_cnt++;
                    }
                }
            }
        }
        al.add(local_cnt);
    }
}
