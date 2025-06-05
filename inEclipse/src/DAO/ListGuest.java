package DAO;

import Model.Guest;

import java.util.ArrayList;
import java.util.List;
public class ListGuest {
    private ArrayList<Guest> arrayGuest;

    public ListGuest(ArrayList arrayGuest) {
        this.arrayGuest = arrayGuest;
    }

    public ArrayList getArrayGuest() {
        return arrayGuest;
    }

    public void addGuest(Guest g){
        arrayGuest.add(g);
    }
 
    public List<Guest> searchGuestById(String s){
     return arrayGuest.stream().filter(item->item.getPersonalDetails().getId()==s).toList();
    }
    
    
}
