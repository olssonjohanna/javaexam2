package Model;

import java.io.*;

public abstract class ManageAdmin {
    public static AllAdmins getAllAdmins() {
        AllAdmins admins = null;
        try {
            FileInputStream fileIn = new FileInputStream("Admins.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            admins = (AllAdmins) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException e) {

        } catch (ClassNotFoundException c) {

        }
        return admins;
    }


    public static void saveAdmins(AllAdmins admins) {
        try {
            FileOutputStream fileOut = new FileOutputStream("Admins.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(admins);
            out.close();
            fileOut.close();
        } catch (IOException e) {
        }
    }
}