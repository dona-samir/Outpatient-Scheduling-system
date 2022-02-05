/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outpatient;

/**
 *
 * @author Samir
 */
public class Person {

    private String name;

    private String Number;

    private String email;

    private String Password;

    public Person(String name, String Number, String email, String Password) {
        this.name = name;
        this.Number = Number;
        this.email = email;
        this.Password = Password;
    }

    public Person() {
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "name : " + name + ", Number : " + Number  ;
    }
    
}

