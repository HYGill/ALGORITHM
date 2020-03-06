package PROGRAMMERS.해시;

import java.util.*;

public class Q_베스트앨범 {
    static Integer[] answer = {};
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        solution(genres, plays);
    }

    static public void solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();
        // 장르 정렬
        HashMap<String, Integer> genresHash = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            genresHash.put(genres[i], genresHash.getOrDefault(genres[i], plays[i]) + plays[i]);
        }
        List<String> sortGenres = sortByValue(genresHash);

        // play 횟수 별로 정렬
        HashMap<Integer, Integer> playsHash = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            playsHash.put(i, plays[i]);
        }
        List<Integer> sortPlays = sortByValueInt(playsHash);
        for (int i = 0; i < sortGenres.size(); i++){
            int cnt = 0;
            for(int n : sortPlays){
                if(genres[n].equals(sortGenres.get(i))){
                    result.add(n);
                    cnt++;
                    if(cnt > 1) break;
                }
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
            System.out.println(answer[i]);
        }
    }

    public static List<String> sortByValue(HashMap<String, Integer> map){
        List<String> list = new ArrayList<String>();
        list.addAll(map.keySet());

        Collections.sort(list, new Comparator<Object>(){
            public int compare(Object o1,Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable<Object>) v1).compareTo(v2);
            }
        });
        Collections.reverse(list);
        return list;
    }

    public static List<Integer> sortByValueInt(HashMap<Integer, Integer> map){
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(map.keySet());

        Collections.sort(list, new Comparator<Object>(){
            public int compare(Object o1,Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable<Object>) v1).compareTo(v2);
            }
        });
        Collections.reverse(list);
        return list;
    }
}
