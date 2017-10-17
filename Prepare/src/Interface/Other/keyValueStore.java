package Interface.Other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class keyValueStore {
    static class pair implements Comparable<pair>{
        Integer key;
        String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getKey() {

            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public pair(int key, String value) {
            this.key = key;
            this.value = value;
        }


        @Override
        public int compareTo(pair o) {
            return key.compareTo(o.key);
        }
    }

    public static void main(String[] args) {
        List<pair> list = new ArrayList<>();
        list.add(new pair(1, "a"));
        list.add(new pair(3, "a"));
        list.add(new pair(5, "a"));
        list.add(new pair(7, "a"));
        list.add(new pair(9, "a"));
        list.add(new pair(2, "a"));
        list.add(new pair(4, "a"));
        list.add(new pair(6, "a"));
        list.add(new pair(8, "a"));
        list.add(new pair(10, "a"));
        Collections.sort(list);
        for(pair cur : list){
            System.out.println(cur.key+" " +cur.value);
        }
    }
}
