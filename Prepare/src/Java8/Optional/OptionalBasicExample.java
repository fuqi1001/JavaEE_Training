package Java8.Optional;

import java.util.Optional;

public class OptionalBasicExample {
    public static void main(String[] args) {
        Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional: " + gender);
        System.out.println("Non-Emtpy Optional: Gender value: "+ gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: "+ Optional.ofNullable(answer2));

        // NullPointException
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));
    }
}
