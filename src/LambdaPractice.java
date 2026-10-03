import entity.Roles;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaPractice {

    public static void main(String[] args) {
        User example = new User(1, "example", 20, "example@xyz.com", Roles.ADMIN, true);
        User exampleTwo = new User(2, "exampleTwo", 21, "exampleTwo@xyz.com", Roles.MODERATOR, false);

        List<User> users = new ArrayList<>();
        users.add(example);
        users.add(exampleTwo);

        //Predicate T -> boolean | То есть, говорим проверить что-то и является это true или false
        Predicate<User> userPredicate = user -> user.getAge() > 18;
        System.out.println(userPredicate.test(example));

        Predicate<User> userPredicate1 = user -> user.getRoles() == Roles.ADMIN;
        System.out.println(userPredicate1.test(example));

        Predicate<User> predicateMore = user -> {
            System.out.println("Check user: " + example.getName());
            return user.getAge() >= 18;
        };
        System.out.println(predicateMore.test(example));

        System.out.println("---------------------------");

        //Consumer T -> void | Принимает что-то, но ничего не возвращает

        Consumer<User> consumer = user -> System.out.println(user.getName());
        consumer.accept(example);

        users.forEach(user -> System.out.println(user.getName()));

        System.out.println("---------------------------");

        //Function T -> R | Принимает T и превращает его в R

        Function<User, String> function = user -> user.getName();
        String functionTest = function.apply(example);
        System.out.println(functionTest);

        Function<User, Integer> functionTwo = user -> user.getAge();
        Integer functionTwoTest = functionTwo.apply(example);
        System.out.println(functionTwoTest);

        System.out.println("---------------------------");

        //Supplier () -> T | Ничего не принимает, но что-то возвращает

        Supplier<String> supplier = () -> "Hello";
        System.out.println(supplier.get());

        System.out.println("-------------------------");

        // Method Reference
        users.forEach(System.out::println);

        Function<User, String> method = User::getName;
        String test = method.apply(example);
        System.out.println(test);
    }
}
