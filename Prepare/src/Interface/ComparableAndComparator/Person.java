package Interface.ComparableAndComparator;

public class Person implements Comparable<Person> {

    int age;
    String name;

    Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.name);
    }
}
