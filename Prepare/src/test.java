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

        List<String> list = Arrays.asList("Dbc","Cbc","Bbc","Abc");
        //list.sort((a,b) ->  a.compareTo(b));
        //list.sort(String::compareTo);
        List<String> res = list.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());

        System.out.println(res);
    }


}






//{10,9,10,4,3,8,3,3,6,2,10,10,9,3}
