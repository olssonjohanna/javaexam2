package Model;

import java.io.*;

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
    };


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