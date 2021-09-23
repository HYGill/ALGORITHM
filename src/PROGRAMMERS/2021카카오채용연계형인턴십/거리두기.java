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
    
    for(int i = 0; i < places.length; i++){
      List<Integer[]> people = new ArrayList<>();
      for(int j = 0; j < places[i].length; j++){
        for(int k = 0; k < places[i][j].length(); k++){
          if(places[i][j].charAt(k) == 'P'){
            Integer[] tmp = {j,k};
            people.add(tmp);
          }
        }
      }
      // people에 저장한 거리 기준으로 지키면 1, 안지키면 0
      answer[i] = calcul(people, places[i]);
    }
    
    return answer;
  }
  
  // 거리계산 함수
  // 두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면, T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2|
  public static int calcul(List<Integer[]> people, String[] place){
    for(int i = 0; i < people.size() - 1 ; i++){
      Integer[] nowSpot = people.get(i);
      
      // i+1 부터 모두 검사. distance와 대각선, 파티션 유무
      for(int k = i+1; k < people.size() - 1; k++){
        Integer[] compareSpot = people.get(k);
        int distance = Math.abs(nowSpot[0] - compareSpot[0]) + Math.abs(nowSpot[1] - compareSpot[1]);
        
        if(distance <= 2) {
          boolean flag = false;

          if(nowSpot[0] == compareSpot[0]){
            for(int j = nowSpot[1]; j < compareSpot[1]; j++){
              if(place[nowSpot[0]].charAt(j) == 'X'){
                flag = true;
              }
            }
          }
          // if(세로위치)
          else if(nowSpot[1] == compareSpot[1]){
            if(place[nowSpot[0]+1].charAt(nowSpot[1]) == 'X'){
              flag = true;
            }
          }
          // if(사람이 대각선에 위치하면)
          else if((nowSpot[0] + 1 == compareSpot[0]) && (nowSpot[1] == compareSpot[1] + 1)){
            if(place[nowSpot[0]].charAt(nowSpot[1]-1) == 'X' && place[compareSpot[0]].charAt(compareSpot[1]+1) == 'X'){
              flag = true;
            }
          }
          else if((nowSpot[0] + 1 == compareSpot[0]) && (nowSpot[1] + 1 == compareSpot[1])){
            if(place[nowSpot[0]].charAt(nowSpot[1]+1) == 'X' && place[compareSpot[0]].charAt(compareSpot[1]-1) == 'X'){
              flag = true;
            }
          }

          if(!flag)
            return 0;
            
        }
      }
    }
    return 1;
  }
}