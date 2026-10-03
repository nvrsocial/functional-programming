import entity.Roles;
import entity.User;

import java.util.Optional;

public class OptionalPractice {
    public static void main(String[] args) {
        User userr = new User(1, "userr", 16, "userr@gmail.com", Roles.USER, false);
        User userr2 = new User(2, "userr2", 20, "userr2@gmail.com", Roles.ADMIN, true);


        // Создает Optional, внутри которого гарантировано есть значение
        Optional<User> optionalUser = Optional.of(userr);

//        User user = null;
//        Optional<User> optionalUserNull = Optional.of(user); // null pointer exception

        //Может быть как юзером, так и null
        Optional<User> optionalUser1 = Optional.ofNullable(userr);

        // Создает пустой Optional
        Optional<User> optionalUser2 = Optional.empty();

        //Проверка содержимого, если будет юзер, вернет true, если нету то false
        if (optionalUser.isPresent()) {
            System.out.println("User exists");
        }

        // Наоборот, проверка на пустоту
        if (optionalUser.isEmpty()) {
            System.out.println("User not exitst");
        }

        // get() - Если есть юзер, вернет его без проблем, но если дать на Optional.empty(), то будет NoSuchElementException
        User tempUser = optionalUser.get(); // User tempUser = optionalUser2.get(); - error

        // по сути тот же иф, если существует, будет вывод, если нету юзера - ничего не произойдет
        optionalUser.ifPresent(user -> System.out.println(user.getEmail()));

        // тот же if но с else
        optionalUser.ifPresentOrElse(user -> System.out.println(user.getEmail()), () -> System.out.printf("User not exists"));

        // если юзер есть, то запишем его в переменную result, если нету, то вернем дефолтную
        User result = optionalUser.orElse(userr2);

        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));
    }
}
