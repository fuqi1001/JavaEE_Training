import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for(int i = 0; i < size; i++){
            int cur_size = sc.nextInt();
            int[] num = new int[cur_size];
            for(int j = 0; j < cur_size; j++) {
                num[j] = sc.nextInt();
            }
            System.out.println(help(num));
        }
    }

    public static int help(int[] num) {
        int max = num[0];
        int maxCount = countZero(num[0]);

        for(int n : num) {
            int current = countZero(n);
               if(maxCount <= current && max < n) {
                   maxCount = current;
                   max = n;
               }
        }
        return max;
    }

    public static int countZero(int num) {
        String str = String.valueOf(num);
        int count = 0;
        for(char c : str.toCharArray()) {
            if(c == '0'){
                count++;
            }
        }
        return count;
    }


}






//{10,9,10,4,3,8,3,3,6,2,10,10,9,3}
