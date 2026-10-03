import entity.Roles;
import entity.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamPractice {
    public static void main(String[] args) {
        User user1 = new User(1, "Idk", 17, "idk@xyz.com", Roles.USER, false);
        User user2 = new User(2, "Example", 23, "example.com", Roles.ADMIN, true);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        // stream() - берем поток данных(т.е всё что есть в листе)
        // filter() - работает по принципу true/false, оставляет значения которые выполняют требования
        // toList() - просто запись в другую коллекцию
        List<User> list1 = users.stream()
                        .filter(user -> user.getAge() >= 18)
                        .toList();
        list1.forEach(System.out::println); // only id 2

        System.out.println();

        // map() - отвечает "во что превратить елемент", то есть из User в String | User -> String or Int
        List<String> list2 = users.stream()
                .map(User::getName)
                .toList();
        list2.forEach(System.out::println);

        System.out.println();

        // Комбинация параметров, вывести имена юзеров в которых активный статус
        List<String> list3 = users.stream()
                .filter(user -> user.isActive())
                .map(User::getName)
                .toList();
        list3.forEach(System.out::println);

        // Несколько аргументов в filter
        List<User> list4 = users.stream()
                .filter(user -> user.isActive() && user.getAge() >= 18)
                .toList();

       /*List <User> list4 = users.stream()
                .filter(user -> user.isActive())
                .filter(user -> user.getAge() >= 18)
                .toList();*/

        System.out.println();

        //Сразу выписываем колекцию с помощью forEach
        users.stream()
                .filter(user -> user.getAge() >= 18)
                .forEach(System.out::println);

        System.out.println();

        //sorted - обычная сортировка, параметр .reversed сортировка от большего к меньшему
        List<User> list5 = users.stream()
                .sorted(Comparator.comparingInt(User::getAge))  //.reversed()
                .toList();
        list5.forEach(System.out::println);

        System.out.println();

        // .count() - счетчик
        long count = users.stream()
                .filter(User::isActive)
                .count(); // return long
        System.out.println(count);

        System.out.println();

        Optional<User> admin = users.stream()  // Optional, потому что админа может и не быть
                .filter(user -> user.getRoles() == Roles.ADMIN)
                .findFirst();
        System.out.println(admin);
    }
}
