package Model;

import java.io.*;
import java.util.ArrayList;

public abstract class ManageStudent {

    public static AllStudents getAllStudents() {
        AllStudents students = null;
        try {
            FileInputStream fileIn = new FileInputStream("students.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            students = (AllStudents) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException i) {

        } catch (ClassNotFoundException c) {

        }
        return students;
    }

    public static ArrayList<Course> getCourses(String email) {
        AllStudents students = null;
        try {
            FileInputStream fileIn = new FileInputStream("students.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            students = (AllStudents) in.readObject();

            for (int i = 0; i < students.getStudents().size(); i++) {
                if (students.getStudents().get(i).getEmail().equals(email)) {
                    ArrayList<Course> returnString = students.getStudents().get(i).getCourses();
                    return returnString;
                }
            }
            in.close();
            fileIn.close();

        } catch (IOException i) {

        } catch (ClassNotFoundException c) {

        }
        return null;
    }

    public static boolean addCourse(String studentEmail, String courseName, int courseID){
        AllStudents students = null;

        try {
            FileInputStream fileIn = new FileInputStream("students.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            students = (AllStudents) in.readObject();

            for (int i = 0; i < students.getStudents().size(); i++){
                if (students.getStudents().get(i).getEmail().equals(studentEmail)) {
                    Course course = ManageCourse.getCourseById(courseID);
                    if (course != null){
                        students.getStudents().get(i).addCourse(course);
                        return true;
                    }
                }
            }
            in.close();
            fileIn.close();

        } catch (IOException i) {

        } catch (ClassNotFoundException c) {

        }
        return false;
    };

    public static void saveStudents(AllStudents students) {
        try {
            FileOutputStream fileOut = new FileOutputStream("students.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(students);
            out.close();
            fileOut.close();
        } catch (IOException i) {

        }
    }

}


