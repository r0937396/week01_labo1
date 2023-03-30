package demo;

import java.util.ArrayList;
import java.util.List;
import demo.User;

import org.hibernate.Remove;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserService {
    // User elke = new User("Elke", 44, "elke@ucll.be", "elke");
    // User miyo = new User("Miyo", 15, "miyo@ucll.be", "miyo");
    // User eric = new User("Eric", 65, "eric@kuleuven.be", "eric");
    // User yuki = new User("Yuki", 13, "yuki@ucll.be", "yuki");
    // User stijn = new User("Stijn", 45, "stijn@ucll.be", "stijn");

    @Autowired
    private UserRepository userRepository;

    public UserService() {
        // addUser(elke);
        // addUser(miyo);
        // addUser(eric);
        // addUser(yuki);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersWithAgeOlderThan(int age) {
        return userRepository.findUsersByAgeAfter(age);
    }
    

    public User getOldestUser() {
        User oldest = null;
        if (userRepository.findAll().size()>0) {
            oldest = userRepository.findAll().get(0);
            for (User user : userRepository.findAll()) {
                if (user.getAge() > oldest.getAge())
                    oldest = user;
            }
        }
        return oldest;
    }

    public User getUserWithName(String name) {
        return userRepository.findAll().stream().filter(user -> user.getName().equals(name)).toList().get(0);
    }

    public boolean addUser(User user) {
        if(getUserWithEmail(user.getEmail()) != null){
            return false;
        }
        userRepository.save(user);
        return true;
    } 
    
    public User getUserWithEmail(String mail){
        return userRepository.findUserByEmail(mail);
    
    }
    public User removeUser(String email){
        User removeUser = getUserWithEmail(email);
        if (removeUser != null){
            userRepository.findAll().remove(removeUser);
            return removeUser;
        }
        return null;
    }
    public List<User> getUserWithEmailAndAge(int age, String email){
        List<User> users = new ArrayList<>();
        for (User usermail : userRepository.findAll()) {
            if (usermail.getEmail().equals(email) && usermail.getAge() == age) {
                users.add(usermail);
            }
        }
        return users;
    } 
    public List<User> getUserWithagebetween(int age_min, int age_max){
        List<User> userse = new ArrayList<>();
        for (User userage : userRepository.findAll()) {
            if (userage.getAge() >= age_min && userage.getAge() <= age_max) {
                userse.add(userage);
            }
        }
        return userse;
    } 

   
}
    

