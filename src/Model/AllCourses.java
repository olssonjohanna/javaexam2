package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class AllCourses implements Serializable{
    private ArrayList<Course> courses;

    public AllCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public AllCourses(){
        this.courses = new ArrayList<>();
    }

    public boolean addCourse(Course course){
        for(int i=0 ; i<courses.size() ; i++){
            if(Objects.equals(course.getCourseID(), courses.get(i).getCourseID())){
                return false;
            }
        }
        courses.add(course);
        return true;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "This is all courses: "+ courses;
    }
}
