package Controller;

import Model.*;

public class Controller {
    private AllTeachers teachers;
    private AllStudents students;
    private AllAdmins admin;

    public void Controller() {
    }

    public boolean tryLoginTeacher(String email, String password) {
        teachers = ManageTeacher.getAllTeachers();
        for (int i = 0; i < teachers.getTeachers().size(); i++) {
            if (teachers.getTeachers().get(i).getEmail().equals(email) && teachers.getTeachers().get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean tryLoginStudent(String email, String password) {
        students = ManageStudent.getAllStudents();
        for (int i = 0; i < students.getStudents().size(); i++) {
            if (students.getStudents().get(i).getEmail().equals(email) && students.getStudents().get(i).getPassword().equals(password)) {
                return true;
            }

        }
        return false;
    }

    public boolean tryLoginAdmin(String email, String password) {
        admin = ManageAdmin.getAllAdmins();
        for (int i = 0; i < admin.getAdmin().size(); i++) {
            if (admin.getAdmin().get(i).getEmail().equals(email) && admin.getAdmin().get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}