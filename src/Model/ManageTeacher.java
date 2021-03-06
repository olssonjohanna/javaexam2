package Model;

import java.io.*;
import java.util.ArrayList;

public abstract class ManageTeacher {
    public static AllTeachers getAllTeachers (){
        AllTeachers teachers = null;
        try {
            FileInputStream fileIn = new FileInputStream("teachers.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            teachers = (AllTeachers) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException i) {

        } catch (ClassNotFoundException c) {

        }
        return teachers;
    }

    public static ArrayList<Course> getCourses(String email) {
        AllTeachers teachers = null;
        try {
            FileInputStream fileIn = new FileInputStream("teachers.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            teachers = (AllTeachers) in.readObject();

            for (int i = 0; i < teachers.getTeachers().size(); i++) {
                if (teachers.getTeachers().get(i).getEmail().equals(email)) {
                    ArrayList<Course> returnString = teachers.getTeachers().get(i).getCourses();
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

    public static boolean addCourse(String teacherEmail, String courseName, int courseID){
        AllTeachers teachers = null;

        try {
            FileInputStream fileIn = new FileInputStream("teachers.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            teachers = (AllTeachers) in.readObject();
            for (int i = 0; i < teachers.getTeachers().size(); i++){
                if (teachers.getTeachers().get(i).getEmail().equals(teacherEmail)) {

                    Course course = ManageCourse.getCourseById(courseID);

                    if (course != null){
                        teachers.getTeachers().get(i).addCourseTea(course);
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
    }

    public static void saveTeachers (AllTeachers teachers){
        try {
            FileOutputStream fileOut = new FileOutputStream("teachers.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(teachers);
            out.close();
            fileOut.close();
        } catch (IOException i) {

        }
    }

}
