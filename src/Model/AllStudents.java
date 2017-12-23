package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class AllStudents implements Serializable{
    private ArrayList<Student> students;

    public AllStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public AllStudents(){
        this.students = new ArrayList<>();
    }

    public boolean addStudent(Student student){
        for(int i=0 ; i<students.size() ; i++){
            if(student.getEmail().equals(students.get(i).getEmail())){
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "This is all students: "+ students;
    }
}
