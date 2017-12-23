package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class AllTeachers implements Serializable{
    private ArrayList<Teacher> teachers;

    public AllTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public AllTeachers(){
        this.teachers = new ArrayList<>();
    }

    public boolean addTeacher(Teacher teacher){
        for(int i=0 ; i<teachers.size() ; i++){
            if(teacher.getEmail().equals(teachers.get(i).getEmail())){
                return false;
            }
        }
        teachers.add(teacher);
        return true;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    @Override
    public String toString() {
        return "This is all teachers: " + teachers;
    }
}
