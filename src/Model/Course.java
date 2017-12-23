package Model;

import java.io.Serializable;
import java.util.Objects;

public class Course implements Serializable{
    private String name;
    private int courseID;

    public Course(String name, int courseID) {
        this.name = name;
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "Course{" + "name='" + name + '\'' + ", courseID=" + courseID + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getCourseID() == course.getCourseID() &&
                Objects.equals(getName(), course.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getCourseID());
    }
}
