package demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findUsersByAgeAfter(int age);
    public User findUserByEmail(String email);
}
