package PROGRAMMERS.카카오인턴쉽2019;

import java.util.HashMap;
import java.util.Map;

public class 지형이동 {
    static int answer = 0;
    static int union = 0;
    static int height;
    static Map<Integer, Integer> unionMap = new HashMap<>();
    public static void main(String[] args) {
        int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
        height = 3;

        System.out.println(solution(land));
    }

    static public int solution(int[][] land) {
        boolean[][] visited = new boolean[4][4];
        int[][] landUnion = new int[4][4];

        // 깊은 복사(1차원 배열은 clone 으로 해결 가능)
        for(int i = 0; i < 4; i++){
            System.arraycopy(land[i], 0, landUnion[i], 0, land[0].length);
        }

        // 영역 지정
        Map<Integer, Integer> unionCnt = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(!visited[i][j]){
                    union++;
                    visited[i][j] = true;
                    landUnion[i][j] = union;
                    unionCnt.put(union, 1);
                    DFS(i, j, land, landUnion, visited, unionCnt);
                }
            }
        }

        findBridge(unionMap, 0, 0, land, landUnion, 1, 0, unionCnt);

        // 최솟값 저장된 것 뺄셈
        for (int i = 1; i < unionMap.size(); i++) {
            int tmp = unionMap.get(i);
            int tmp2 = unionMap.get(i+1);
            answer = Math.abs(tmp - tmp2);
        }

        return answer;
    }

    static int[] goX = {0, 1, 0, -1}; // 우 좌
    static int[] goY = {1, 0, -1, 0}; // 하 상
    static public void DFS(int x, int y, int[][] land, int[][] landUnion, boolean[][] visited, Map<Integer, Integer> unionCnt){
        for(int i = 0; i < 4; i++) {
            int dx = x + goX[i];
            int dy = y + goY[i];

            if ((-1 < dx && dx < 4) && (-1 < dy && dy < 4) && !visited[dx][dy]) {
                int tmp = land[dx][dy] - land[x][y];
                if(Math.abs(tmp) <= height) {
                    visited[dx][dy] = true;
                    landUnion[dx][dy] = union;
                    unionCnt.put(union, unionCnt.get(union)+1);
                    DFS(dx, dy, land, landUnion, visited, unionCnt);
                }
            }
        }
    }

    static int tmpX;
    static int tmpY;
    static public void findBridge(Map<Integer, Integer> unionMap, int x, int y, int[][] land, int[][] landUnion, int nowNum, int cnt, Map<Integer, Integer> unionCnt){
        for(int i = 0; i < 4; i++) {
            int dx = x + goX[i];
            int dy = y + goY[i];

            // 상하좌우 검사 후 자신의 영역과 다른 영역이 감지 될 시 저장, 최솟값만을 저장한다
            if((-1 < dx && dx < 4) && (-1 < dy && dy < 4) && landUnion[dx][dy] != nowNum){
                if(!unionMap.containsKey(union)) {
                    unionMap.put(union, land[dx][dy]);
                } else {
                    if(unionMap.get(union) > land[dx][dy]) {
                        unionMap.put(union, land[dx][dy]);
                    }
                }
            }
            int tmpX = dx;
            int tmpY = dy;
        }

        // 영역을 다 돌지 않았을 때
        if(unionCnt.get(nowNum) > cnt)
            findBridge(unionMap, tmpX, tmpY, land, landUnion, nowNum, cnt + 1, unionCnt);
        // 영역을 다 돌았고, 전체 영역 숫자에 벗어나지 않는 범위에서 영역 번호 증가 후 다음 영역 검
        else if(union <= nowNum)
            findBridge(unionMap, tmpX, tmpY, land, landUnion, nowNum + 1, 1, unionCnt);
        else
            return;
    }
}
