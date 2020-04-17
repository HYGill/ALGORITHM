package BOJ.삼성;

import java.util.*;

public class Q_16236_아기상어_BFS {
    static int nowSize = 2;
    static int time = 0;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[][] cage = new int[n][n];

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                cage[i][j] = input.nextInt();
                int tmp = cage[i][j];
                if(tmp == 9) {
                    startX = i;
                    startY = j;
                    cage[i][j] = 0;
                }
            }
        }

        search(startX, startY, cage, n);
        System.out.println(time);
    }

    public static void search(int x, int y, int[][] cage, int n){
        Info startInfo = new Info(x, y, 0);

        while(true) {
            List<Info> caseInfo = BFS(startInfo, cage, n);
            if(caseInfo.isEmpty()) {
                break;
            }

            Collections.sort(caseInfo, new Comparator<Info>() {
                @Override
                public int compare(Info o1, Info o2) {
                    if (caseInfo.size() > 1 && o1.distance != o2.distance)
                        return o1.distance - o2.distance;
                    if (o1.distance == o2.distance && o1.x != o2.x)
                        return o1.x - o2.x;
                    if (o1.distance == o2.distance && o1.x == o2.x)
                        return o1.y - o2.y;
                    return 0;
                }
            });

            Info tmp = caseInfo.get(0);
            cage[tmp.x][tmp.y] = 0;
            time += tmp.distance;
            startInfo = new Info(tmp.x, tmp.y, 0);
            cnt++;
            if (cnt == nowSize) {
                cnt = 0;
                nowSize++;
            }
        }
    }

    static int[] goX = {-1, 0, 1, 0};
    static int[] goY = {0, 1, 0, -1};
    public static List<Info> BFS(Info now, int[][] cage, int n) {
        Queue<Info> queue = new LinkedList<>();
        List<Info> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        queue.add(now);
        while (!queue.isEmpty()) {
            Info tmp = queue.poll();
            visited[tmp.x][tmp.y] = true;
            for (int i = 0; i < 4; i++) {
                int dx = tmp.x + goX[i];
                int dy = tmp.y + goY[i];

                // 지나간 길이 아니고, 자기 몸과 같거나 작으면 움직일 수 있다.
                if((-1 < dx && dx < n) && (-1 < dy && dy < n) && visited[dx][dy] == false && cage[dx][dy] <= nowSize){
                    visited[dx][dy] = true;
                    if(cage[dx][dy] < nowSize && cage[dx][dy] != 0){
                        result.add(new Info(dx, dy, tmp.distance + 1));
                    }else {
                        queue.add(new Info(dx, dy, tmp.distance + 1));
                    }
                }
            }
        }
        return result;
    }

    static class Info{
        int x;
        int y;
        int distance;
        public Info(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}