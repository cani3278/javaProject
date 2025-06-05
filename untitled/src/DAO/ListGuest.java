package DAO;

import Model.Guest;

import java.util.ArrayList;
public class ListGuest {
    private ArrayList arrayGuest;

    public ListGuest(ArrayList arrayGuest) {
        this.arrayGuest = arrayGuest;
    }

    public ArrayList getArrayGuest() {
        return arrayGuest;
    }

    public void addGuest(Guest g){
        arrayGuest.add(g);
    }
 //אולי אמור להיות בBL
    public void searchGuestById(String s){
//        arrayGuest.stream().findFirst(s==);
//        arrayGuest.find();

    }
}
