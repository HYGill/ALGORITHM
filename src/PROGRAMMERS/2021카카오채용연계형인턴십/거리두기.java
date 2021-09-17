class Solution {
  public static void main(String[] args) {
    String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
                         {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
                         {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
    
    System.out.println(solution(places));
  }

  
  public int[] solution(String[][] places) {
    int[] answer = {};
    
    List<Integer[]> people = new ArrayList<>();
    for(int i = 0; i < places.length(); i++){
      for(int j = 0; j < places[i].length(); j++){
        if(places[i].charAt(j) == 'P')
          people.add([i,j]);
      }
    }
    
    // people에 저장한 것 거리 계산
    
    return answer;
  }
  
  // 거리계산 함수
  public static void distance(String splitPlaces[][], int j, int k){
    
  }
}
