package demo;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;
    private User elke;
    private User eric;
    private User yuki;
    private User miyo;
    @BeforeEach
    public void setUp() {
    //given
    elke = new User("Elke", 45, "elke@ucll.be", "t");
    eric = new User("Eric", 65, "eric@ucll.be", "t");
    yuki = new User("Yuki", 13, "yuki@ucll.be", "t");
    miyo = new User("Miyo", 15, "miyo@ucll.be", "t");
    }
    @Test
    public void givenNoUsers_whenValidUserAdded_ThenUserIsAddedAndUserIsReturned() {
        // given
        when(userRepository.save(elke)).thenReturn(elke);
        // when
        boolean added = userService.addUser(elke);
        // then
        assertTrue(added);
    }
    @Test
    public void givenUsersWhith1UserOlderThan20_whenGetUsersOlderThan20_thenListWith1UserOlderThan20IsReturned() {
        //given
        List<User> usersAbove20 = new ArrayList<User>();
        usersAbove20.add(elke);
        when(userRepository.findUsersByAgeAfter(20)).thenReturn(usersAbove20);
        //when
        List<User> result = userService.getUsersWithAgeOlderThan(20);
        //then
        assertEquals(usersAbove20.size(), result.size());
        assertTrue(result.contains(elke));
        assertFalse(result.contains(miyo));
    }
    @Test
    public void givenUsersWhithNoUsersOlderThan20_whenGetUsersOlderThan20_thenEmptyListIsReturned() {
        //given
        List<User> usersAbove20 = new ArrayList<User>();
        when(userRepository.findUsersByAgeAfter(20)).thenReturn(usersAbove20);
        //when
        List<User> result = userService.getUsersWithAgeOlderThan(20);
        //then
        assertEquals(usersAbove20.size(), result.size());
        assertFalse(result.contains(yuki));
        assertFalse(result.contains(miyo));
    }
   
    @Test
    void given4Users_whenNewUserWithNotAlreadyUsedEmailIsAdded_thenUserIsAdded() {
    //given
        User stijn = new User("Stijn", 46, "stijn@ucll.be", "t");
        when(userRepository.save(stijn)).thenReturn(stijn);
        //when
        boolean added = userService.addUser(stijn);
 //then
 assertTrue(added);
 }
 @Test
 void given4Users_whenNewUserWithAlreadyUsedEmailIsAdded_thenUserIsNotAdded() {
        //given
        User otherElke = new User("Elke", 20, "elke@ucll.be", "elkeelke");
        when(userRepository.findUserByEmail("elke@ucll.be")).thenReturn(elke);
        //when
        boolean added = userService.addUser(otherElke);
        //then
        assertFalse(added);
 }
}