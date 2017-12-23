package Model;

import java.io.*;

public abstract class ManageStudent {

    public static AllStudents getAllStudents (){
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

    public static void saveStudents (AllStudents students){
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
