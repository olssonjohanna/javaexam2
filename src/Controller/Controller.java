package Controller;

import Model.Admin;
import Model.AllStudents;
import Model.AllTeachers;

public class Controller {
    private AllTeachers teachers;
    private AllStudents students;
    private Admin admin;

    public void Controller() {
    }

    public boolean tryLoginTeacher(String email, String password){
        for(int i=0; i<teachers.getTeachers().size() ; i++){
            if(teachers.getTeachers().get(i).getEmail().equals(email) && teachers.getTeachers().get(i).getPassword().equals(password)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public boolean tryLoginStudent(String email, String password){
        for(int i=0; i<students.getStudents().size() ; i++){
            if(students.getStudents().get(i).getEmail().equals(email) && students.getStudents().get(i).getPassword().equals(password)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    public boolean tryLoginAdmin(String email, String passowrd){
         if (admin.getEmail().equals(email) && admin.getPassword().equals(passowrd)){
             return true;
         }else{
             return false;
         }




    }

}
