import Entities.User;
import Repositories.UserRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        User user = new User();
        user.setName("John Doe");
        user.setEmail("johndoe@example.com");
        userRepository.create(user);

        User retrievedUser = userRepository.findById(1L);
        System.out.println(retrievedUser.getName());

        List<User> users = userRepository.findByName("John");
        for (User u : users) {
            System.out.println(u.getName());
        }

        PersistenceManager.close();
    }
}
