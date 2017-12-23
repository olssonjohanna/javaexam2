package Model;

import java.io.*;

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
