/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guı_version_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ebb
 */
public class User {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String birthDate;

    public User(String name, String surname, String email, String password, String birthDate) {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        writeFile();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", surname=" + surname + ", email=" + email + ", birthDate=" + birthDate + "]";
    }

    public void writeFile() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("User.txt", true));
            writer.append(this.name + " " + this.surname + " " + this.email + " " + this.birthDate + " " + this.password + "\n");
            writer.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
