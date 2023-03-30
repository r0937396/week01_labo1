package demo;

import java.util.ArrayList;
import java.util.List;
import demo.User;

import org.hibernate.Remove;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    User elke = new User("Elke", 44, "elke@ucll.be", "elke");
    User miyo = new User("Miyo", 15, "miyo@ucll.be", "miyo");
    User eric = new User("Eric", 65, "eric@kuleuven.be", "eric");
    User yuki = new User("Yuki", 13, "yuki@ucll.be", "yuki");
    User stijn = new User("Stijn", 45, "stijn@ucll.be", "stijn");

    
    private List<User> userRepository = new ArrayList<>();

    public UserService() {
        addUser(elke);
        addUser(miyo);
        addUser(eric);
        addUser(yuki);
    }

    public List<User> getAllUsers() {
        return userRepository;
    }

    public List<User> getUsersWithAgeOlderThan(int age) {
        return userRepository.stream().filter(user -> user.getAge()>age).toList();
    }
    

    public User getOldestUser() {
        User oldest = null;
        if (userRepository.size()>0) {
            oldest = userRepository.get(0);
            for (User user : userRepository) {
                if (user.getAge() > oldest.getAge())
                    oldest = user;
            }
        }
        return oldest;
    }

    public User getUserWithName(String name) {
        return userRepository.stream().filter(user -> user.getName().equals(name)).toList().get(0);
    }

    public boolean addUser(User user) {
        for(User i : userRepository){
            if (i.getEmail().contains(user.getEmail()))  {
                return false;
            } 
        }
        return userRepository.add(user);
    } 
    
    public User getUserWithEmail(String mail){
        for (User usermail : userRepository) {
            if (usermail.getEmail().equals(mail)) {
                return usermail;
            }

        }
        return null;
    
    }
    public User removeUser(String email){
        User removeUser = getUserWithEmail(email);
        if (removeUser != null){
            userRepository.remove(removeUser);
            return removeUser;
        }
        return null;
    }
    public List<User> getUserWithEmailAndAge(int age, String email){
        List<User> users = new ArrayList<>();
        for (User usermail : userRepository) {
            if (usermail.getEmail().equals(email) && usermail.getAge() == age) {
                users.add(usermail);
            }
        }
        return users;
    } 
    public List<User> getUserWithagebetween(int age_min, int age_max){
        List<User> userse = new ArrayList<>();
        for (User userage : userRepository) {
            if (userage.getAge() >= age_min && userage.getAge() <= age_max) {
                userse.add(userage);
            }
        }
        return userse;
    } 

   
}
    

