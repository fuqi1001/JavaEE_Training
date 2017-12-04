package InterviewQuestion;

import java.util.*;

public class StockSort {
    public static void topKShare(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() +" " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 100);
        map.put("two", 200);
        map.put("three", 300);
        map.put("four", 400);
        map.put("five", 500);
        map.put("six", 600);
        map.put("seven", 700);
        map.put("eight", 800);
        map.put("nine", 900);
        map.put("ten", 1000);

        topKShare(map);
    }
}
