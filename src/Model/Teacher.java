package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Teacher implements Serializable {
    private String email;
    private String password;
    private String name;
    public ArrayList<Course> courses;

    public Teacher(String email, String password, String name) {
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

    public void addCourseTea(Course course){
        courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
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
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getEmail(), teacher.getEmail()) &&
                Objects.equals(getPassword(), teacher.getPassword()) &&
                Objects.equals(getName(), teacher.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmail(), getPassword(), getName());
    }
}
