package Interface.ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CompareComparatorAndComparableTest {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("ccc", 20));
        list.add(new Person("AAA", 10));
        list.add(new Person("bbb", 30));
        list.add(new Person("ddd", 40));

        for (Person person : list) {
            System.out.println(person.name +" " + person.age);
        }
        System.out.println();

        Collections.sort(list);

        System.out.printf("Original sort, list: %s\n", list);

        for (Person person : list) {
            System.out.println(person.name +" " + person.age);
        }
        System.out.println();


        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.age - o1.age;
            }
        });


        //Collections.sort(list, new DescAgeComparator());

        //Collections.sort(list,((o1, o2) -> o2.age - o1.age));


        for (Person person : list) {
            System.out.println(person.name +" " + person.age);
        }
        System.out.println();

        testEqual();
    }

    private static class DescAgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.age - o1.age;
        }
    }

    private static void testEqual() {
        Person p1 = new Person("eee", 100);
        Person p2 = new Person("eee", 100);
        if(p1.equals(p2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
            System.out.println(p1);
            System.out.println(p2);
        }
    }
}
