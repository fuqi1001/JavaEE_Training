import java.lang.reflect.Array;
import java.util.*;

public class test {



    public static void main(String[] args) {
        String str1 = new String("abc");
        str1 = str1.intern();

        String str2 = "abc";

        if(str1 == str2) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
    /*

    public class RetrieveData{
    public static void main(String args[]){
// Standard code
        Session hsession = sf.openSession();
        Query query = hsession.createQuery(hql query);
        List l = query.list();
        ArrayList emplist = (ArrayList)l;
        Iterator i = emplist.iterator();
        while(i.hasNext()){
            Employee e = (Employee);.next();
            System.out.println(e.getEmployeeNo());
            System.out.println(e.getEmployeeName());
            System.out.println(e.getEmployeeAddress());
        }
        hsession.close();
    }
}
     */

}




//{10,9,10,4,3,8,3,3,6,2,10,10,9,3}
