package DAO;

import Model.Room;

import java.util.ArrayList;

public class ListRoom {
    private ArrayList<Room> arrayRoom;

    public ArrayList<Room> getArrayRoom() {
        return arrayRoom;
    }

    public void addRoom(Room r) {
        arrayRoom.add(r);
    }

    public void updateRoom(Room r) {
        Room updatedroom = (Room) arrayRoom.stream().filter(room -> room.equals(r));
        updatedroom.setActive(true);
    }

    public void deleteRoom(Room r) {
        arrayRoom.stream().filter(room -> room.equals(r));
    }

    public ListRoom(ArrayList<Room> arrayRoom) {
        this.arrayRoom = arrayRoom;
    }


}
