package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class AllAdmins implements Serializable {
    private ArrayList<Admin> admins;

    public AllAdmins(ArrayList<Admin> admin) {
        this.admins = admins;
    }

    public AllAdmins(){
        this.admins = new ArrayList<>();
    }

    public boolean addAdmin(Admin admin){
        for(int i=0 ; i<admins.size() ; i++){
            if(admin.getEmail().equals(admins.get(i).getEmail())){
                return false;
            }
        }
        admins.add(admin);
        return true;
    }

    public ArrayList<Admin> getAdmin() {
        return admins;
    }

    @Override
    public String toString() {
        return "This is all admins: " + admins;
    }
}

