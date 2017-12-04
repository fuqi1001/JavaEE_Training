import java.lang.reflect.Array;
import java.util.*;

public class test {

    public String deleteCharacter(String str, List<int[]> list) {
        Collections.sort(list, (o1,o2) -> o1[0] - o2[0]);
        List<int[]> interval = new ArrayList<>();
        int start = list.get(0)[0];
        int end = list.get(0)[1];

        for(int i = 1; i < list.size(); i++) {
            if(list.get(i)[0] < end) {
                end = Math.max(list.get(i)[1], end);
            } else {
                interval.add(new int[] {start, end});
                start = list.get(i)[0];
                end = list.get(i)[1];
            }
        }
        interval.add(new int[] {start, end});
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for(int[] cur : interval) {
            sb.append(str.substring(index, cur[0]));
            index = cur[1] + 1;
        }
        return sb.append(str.substring(index)).toString();
    }


    public static void main(String[] args) {
        test t = new test();
        List<int[]> list = Arrays.asList(new int[]{2,3},new int[]{1,3}, new int[]{4,5});
        System.out.println(t.deleteCharacter("abcdefghij", list));


    }
}




//{10,9,10,4,3,8,3,3,6,2,10,10,9,3}
