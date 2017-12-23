package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Student implements Serializable {
    private String email;
    private String password;
    private String name;
    private ArrayList<Course> courses;

    public Student(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getEmail(), student.getEmail()) &&
                Objects.equals(getPassword(), student.getPassword()) &&
                Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmail(), getPassword(), getName());
    }
}
