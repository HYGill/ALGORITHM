
import java.util.*;

public class Q_베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] answer = solution(genres, plays);
        for(int i : answer){
            System.out.println(i);
        }
    }
    static class Album{
        String genre;
        int play;
        int index;
        
        public Album(String genre, int play, int index){
            this.genre = genre;
            this.play = play;
            this.index = index;
        }
    }
    // 속한 노래가 많이 재생된 장르 수록
    // 장르 내에서 많이 재생된 노래 수록
    // 장르 내에서 재생 횟수가 같은 노래면 고유번호 낮음 순서
    public static int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genresSum = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            genresSum.put(genres[i], genresSum.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> sortList = new LinkedList<>(genresSum.entrySet());
        sortList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o2.getValue() - o1.getValue();
            }
        });

        // 장르 랭킹 List
        List<String> genresLank = new ArrayList<>();
        for(String key : genresSum.keySet()){
            genresLank.add(key);
        }
		
        List<Album> result = new ArrayList<>();
        for(String genre : genresLank){
            List<Album> list = new ArrayList<>();
            for(int i = 0; i < genres.length; i++){
                if(genres[i].equals(genre)){
                    list.add(new Album(genre, plays[i], i));
                }
            }
            list.sort(new Comparator<Album>() {
                @Override
                public int compare(Album o1, Album o2) {
                       int play1 = o1.play;
                       int play2 = o2.play;
                       
                       if(play1 == play2) {
                           return o1.index - o2.index;
                       }
                       else if(play2 > play1) return 1;
                       else return -1;
                }
            });
         
            result.add(list.get(0));
            if(list.size()!= 1){
                result.add(list.get(1));
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).index;
        }

        return answer;
    }
}