package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/oldest")
    public User getOldestUser() {
        return userService.getOldestUser();
    }

    @GetMapping("/search/olderthan")
    public List<User> searchUsersWithAgeOlderThan(@RequestParam("age") int age) {
        return userService.getUsersWithAgeOlderThan(age);
    }

    @GetMapping("/search/{name}")
    public User searchUserWithName(@PathVariable("name") String name) {
        return userService.getUserWithName(name);
    }

    @GetMapping("/adults")
    public List<User> searchUserOlderThen17() {
        return userService.getUsersWithAgeOlderThan(17);
    }

    @GetMapping("/search/email/{email}")
    public User getuserwithemail(@PathVariable("email") String email) {
        return userService.getUserWithEmail(email);
    }

    @GetMapping("/search")
    public List<User> getuserswitheemailandage(@RequestParam("age") int age, @RequestParam("email") String email) {
        return userService.getUserWithEmailAndAge(age, email);
    }

    @GetMapping("/search/age/{min}/{max}")
    public List<User> getUsersWithAgeBetween(@PathVariable("min") int age_mi, @PathVariable("max") int age_mx) {
        return userService.getUserWithagebetween(age_mi, age_mx);
    }

    @PostMapping
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @DeleteMapping("/{email}")
    public User DelAndReturnUser(@PathVariable String email){
        return userService.removeUser(email);
    }
}
