class Solution {
  public static void main(String[] args) {
    String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
                         {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
                         {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
    
    System.out.println(solution(places));
  }

  
  public int[] solution(String[][] places) {
    int[] answer = {};
    
    for(int i = 0; i < places.length(); i++){
      // places의 한 row씩 검사
      String[][] splitPlaces = new String[places.length()][places[i][0].length()];
      
      for(int j = 0; j < places[i].length(); j++){
        for(int k = 0; k < places[i][j].length(); k++){
          String nowChar = places[i][j].getChar(k);
          
          if(nowChar.equals("P")){
            // P나오면 다음 P나올때까지 거리 2 이하일때만 검사
            
          }
          
          splitPlaces[j][k] = nowChar;
        }
      }
    }
    
    return answer;
  }
  
  // bfs
  public static void distance(String splitPlaces[][], int j, int k){
    
  }
}
