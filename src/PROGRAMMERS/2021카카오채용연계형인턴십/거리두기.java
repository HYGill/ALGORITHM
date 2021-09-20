import java.util.ArrayList;
import java.util.List;

class Solution {
  public static void main(String[] args) {
    String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
                         {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
                         {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
    
    System.out.println(solution(places));
  }

  
  public static int[] solution(String[][] places) {
    int[] answer = new int[places.length];
    
    List<Integer[]> people = new ArrayList<>();
    for(int i = 0; i < places.length; i++){
      for(int j = 0; j < places[i].length; j++){
        for(int k = 0; k < places[i][j].length(); k++){
          if(places[i][j].charAt(k) == 'P'){
            Integer[] tmp = {i,j};
            people.add(tmp);
          }
        }
      }
      // people에 저장한 것 거리 계산
      answer[i] = distance(people);
    }
    
    return answer;
  }
  
  // 거리계산 함수
  // 두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면, T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다
  public static int distance(List<Integer[]> people){
    for(int i = 0; i < people.size() - 1 ; i++){
      Integer[] spot1 = people.get(i);
      Integer[] spot2 = people.get(i+1);

      float distance = Math.abs(spot1[0] - spot2[0]) + Math.abs(spot1[1] - spot2[1]);

      if(distance > 2) {
        return 0;
      }
    }
    return 1;
  }
}
