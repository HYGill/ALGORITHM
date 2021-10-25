import java.util.ArrayList;
import java.util.List;

public class 전력망을둘로나누기 {
    static List<Integer>[] list; // 인접리스트 구현
	static int nodeNum;
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}; 
        
        System.out.println(solution(n, wires));
    }

    // dfs로 풀이
    public static int solution(int n, int[][] wires) {
        int answer = 100;
        int idx = 0;
        list = new ArrayList[n+1];
        
        while(idx < n-1) {
	        for(int i = 1; i <= n; i++) {
	        	list[i] = new ArrayList<>();
	        }
	        
	        for(int i=0; i<wires.length; i++) {
                // 간선 하나씩 빼주기
	        	if(idx == i) 
                    continue;

	        	int left = wires[i][0];
	        	int rigth = wires[i][1];
	        	
	        	list[left].add(rigth);
	        	list[rigth].add(left);
	        }
	        
	        nodeNum = 0;
	        dfs(1, -1);
	        int result = Math.abs(n - 2 * nodeNum);
	        answer = Math.min(result, answer);
	        idx++;
        }

        return answer;
    }

    static void dfs(int index, int parent) {
		nodeNum++;
		for(int nextIndex : list[index]) {
			if(parent != nextIndex) {
				dfs(nextIndex, index);
			}
		}
	}
}
