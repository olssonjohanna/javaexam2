package Model;

import java.io.*;

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
