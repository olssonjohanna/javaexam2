package Model;

import java.io.*;
import java.util.ArrayList;

public abstract class ManageAdmin {
    public static AllAdmins getAllAdmins() {
        AllAdmins admins = null;
        try {
            FileInputStream fileIn = new FileInputStream("admins.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            admins = (AllAdmins) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException e) {

        } catch (ClassNotFoundException c) {

        }
        return admins;
    }

    public static boolean adminAddCourse(String courseName, int courseID) {
        AllCourses courses = null;
        try {
            FileInputStream fileIn = new FileInputStream("courses.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            courses = (AllCourses) in.readObject();

            Course course = ManageCourse.getCourseById(courseID);
            if (course != null) {
                courses.addCourse(course);
                return true;
            }
            in.close();
            fileIn.close();

        } catch (IOException i) {

        } catch (ClassNotFoundException c) {

        }
        return false;
    }

    ;


    public static void saveAdmins(AllAdmins admins) {
        try {
            FileOutputStream fileOut = new FileOutputStream("admins.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(admins);
            out.close();
            fileOut.close();
        } catch (IOException e) {
        }
    }
}
/*
    public static ArrayList<Course> getCourses(String email) {
        AllAdmins admins = null;
        try {
            FileInputStream fileIn = new FileInputStream("Admins.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            admins = (AllAdmins) in.readObject();

            for (int i = 0; i < admins.getAdmin().size(); i++) {
                if (admins.getAdmin().get(i).getEmail().equals(email)) {
                    ArrayList<Course> returnString = admins.getAdmin().get(i).getCourse();
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
}


/*
    public static boolean addCourse( String courseName, int courseID){
        AllAdmins admins = null;
        AllCourses course = null;

        try {
            FileInputStream fileIn = new FileInputStream("course.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            admins = (AllAdmins) in.readObject();

            for (int i = 0; i < course.getCourses().size(); i++) {

                if (course.getCourses().get(i).equals(courseID)) {
                    return false;
                }else {
                    Course course1 = ManageCourse.saveCourses(courseID);
                    if (course1 != null) {
                        admins.getAdmin().get(i).addCourse(course1);
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
      */

