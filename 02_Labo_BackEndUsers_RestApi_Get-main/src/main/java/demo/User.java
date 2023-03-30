package demo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "users")


public class User {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    public long id;
    
    
    private String name;
    private int age;
    @Transient
    private List<Integer> membershipYears = new ArrayList<Integer>();
    private String email;
    private String password;
    public String unvalidpswrd = "    ";
    public CharSequence Email;

    public User (){}

    public User(String name, int age, String  email, String password) {
        this.name = name;
        if (age >= 0) 
            this.age = age;
        if ( email.contains("@")){
            this.email = email;
        }
        if (password.contains("    ")) {
            password = "t";
        }
        if (password != (null)){
            this.password = password;
        }
    }

    public User(String name, int age) {
        this.name = name;
        if (age >= 0) 
            this.age = age;
    }

    public int countMembershipYearsAfter1999 () {
        int result = 0;
        for(Integer year: membershipYears) {
            if (year > 1999)
                result++;
        }
        return result;
    }

    public int countYearsOfMembership () {
        return membershipYears.size();
    }

    public void addMembershipYear (int year) {
        membershipYears.add(year);
    }

  
    public int getFirstMembershipYear(){
        int firstyear = 999999 ;
        
        for (final int i : membershipYears){
            if (i < firstyear){
                firstyear = i;
            }
        }
        if (firstyear == 999999){
            return (0);
        }

        return firstyear ;
    }
    public String toString(){
        return(name+" is "+age+" years old and has as email "+email);
    }
    
    public int getNumberOfMembershipYearsIn2000(){
        int count = 0;
        for (final int i : membershipYears){
            if (i < 2999){
                if (i > 1999){
                    count +=1;
                }}
        }
        return(count);
    } 
    public boolean isPasswordCorrect(String pw  ){
        if (password == pw ){
            return true;
        }
        return false;
    }
    
    public int getAge() {
        return this.age;
    }

    public String getName () {
        return name;
    }
    public String getEmail() {
        
        return email;
    }
    public String getPassword(){
        return "@$-"+password+"&%#";
    }


}