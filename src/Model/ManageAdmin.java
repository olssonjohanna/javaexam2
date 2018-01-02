package Model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ManageAdmin {

    public abstract class ManageTeacher {

        public AllTeachers getAllTeachers() {
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

    }
}