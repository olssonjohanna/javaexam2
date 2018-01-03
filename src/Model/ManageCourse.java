package Model;

import java.io.*;
import java.util.ArrayList;

public abstract class ManageCourse {

    public static AllCourses getAllCourses (){
        AllCourses courses = null;
        try {
            FileInputStream fileIn = new FileInputStream("courses.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            courses = (AllCourses) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException i) {

        } catch (ClassNotFoundException c) {

        }
        return courses;
    }

    public static Course getCourseById (int ID){
        AllCourses courses = null;
        try {

            FileInputStream fileIn = new FileInputStream("courses.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            courses = (AllCourses) in.readObject();

            for (int i = 0; i < courses.getCourses().size(); i++) {

                if (courses.getCourses().get(i).getCourseID() != (ID)) {

                    Course toReturn = courses.getCourses().get(i);
                    return toReturn;
                }
            }
            in.close();
            fileIn.close();

        } catch (IOException i) {

        } catch (ClassNotFoundException c) {

        }
        return null;
    }

    public static ArrayList<Course> getAllCoursesOnString (){
        AllCourses courses = null;
        try {
            FileInputStream fileIn = new FileInputStream("courses.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            courses = (AllCourses) in.readObject();

            for (int i = 0; i < courses.getCourses().size(); i++) {
                ArrayList<Course> returnString = courses.getCourses();
                return returnString;
                }

            in.close();
            fileIn.close();

        } catch (IOException i) {

        } catch (ClassNotFoundException c) {

        }
        return null;
    }

    public static void saveCourses (AllCourses courses){
        try {
            FileOutputStream fileOut = new FileOutputStream("courses.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(courses);
            out.close();
            fileOut.close();
        } catch (IOException i) {

        }
    }
}
