package demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNull;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

class UserTest {

    //given
    private String validNameElke = "Elke";
    private int validAgeElke = 44;
    private String validEmailElke = "elke.steegmans@ucll.be";
    private String validPasswordElke = "ikgahetnietvertellenhoor";

 //constructor
 //happy case
 @Test
 void givenValidValues_whenCreatingUser_thenUserIsCreatedWithThoseValues() {
     //when
     User elke = new User(validNameElke, validAgeElke, validEmailElke, validPasswordElke);
    
     //then
     assertNotNull(elke);
     assertEquals(validNameElke, elke.getName());
     assertEquals(validAgeElke, elke.getAge());
     assertEquals(0, elke.countYearsOfMembership());
     assertEquals(validEmailElke, elke.getEmail());
     assertEquals("@$-"+validPasswordElke+"&%#", elke.getPassword());        
 }
    
 //constructor
 //unhappy case
 //invalid negative age
 @Test
 void givenInvalidNegativeAge_whenCreatingUser_thenUserIsCreatedWithAge0() {
     //when
     User elke = new User(validNameElke, -5, validEmailElke, validPasswordElke);
    
     //then
     assertNotNull(elke);
     assertEquals(validNameElke, elke.getName());
     assertEquals(0, elke.getAge());
     assertEquals(0, elke.countYearsOfMembership());
     assertEquals(validEmailElke, elke.getEmail());
     assertEquals("@$-"+validPasswordElke+"&%#", elke.getPassword());        
 }
    
// //countMembershipYearsAfter1999
// //happy case
@Test
void givenUserWithMemberschipYearsAfter1999_whenAskForMembershipYearsAfter1999_thenCorrectNumberIsReturned(){
     //given
     User elke = new User(validNameElke, validAgeElke, validEmailElke, validPasswordElke);
     elke.addMembershipYear(2003);
     elke.addMembershipYear(1999);
     elke.addMembershipYear(2000);

     //when
     int result = elke.countMembershipYearsAfter1999();

     //then
     assertEquals(2, result);
}

// //countMembershipYearsAfter1999
// //unhappy case
// //no membership years after 1999
@Test
 void givenUserWithNoMemberschipYearsAfter1999_whenAskForMembershipYearsAfter1999_then0IsReturned(){
     //given
     User elke = new User(validNameElke, validAgeElke, validEmailElke, validPasswordElke);
     elke.addMembershipYear(1999);
     elke.addMembershipYear(1978);

   //when
     int result = elke.countMembershipYearsAfter1999();

    //then
    assertEquals(0, result);
}
    
}