package Model;

import java.util.ArrayList;

public class AllAdmins {
    private ArrayList<Admin> admin;

    public AllAdmins(ArrayList<Teacher> teachers) {
        this.admin = admin;
    }

    public AllAdmins(){
        this.admin = new ArrayList<>();
    }

    public boolean addAdmin(Admin admin1){
        for(int i=0 ; i<admin.size() ; i++){
            if(admin1.getEmail().equals(admin.get(i).getEmail())){
                return false;
            }
        }
        admin .add(admin1);
        return true;
    }

    public ArrayList<Admin> getAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return "This is all admins: " + admin;
    }
}

