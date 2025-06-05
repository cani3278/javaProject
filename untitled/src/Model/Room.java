package Model;

import java.util.Objects;

public class Room {
    private int numRoom;
    private int numOfBeds;

    private int floor;
    private int level;
    private boolean isActive;
    private static int startPrice;


    public int getNumRoom() {
        return numRoom;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        return getNumRoom() == room.getNumRoom() && numOfBeds == room.numOfBeds && getFloor() == room.getFloor() && getLevel() == room.getLevel() && isActive() == room.isActive();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumRoom(), numOfBeds, getFloor(), getLevel(), isActive());
    }

    public static int getStartPrice() {
        return startPrice;
    }

    public static void setStartPrice(int startPrice) {
        Room.startPrice = startPrice;
    }

    public Room(int numRoom, int floor, int level,int numOfBeds) {
        this.numRoom = numRoom;
        this.numOfBeds = numOfBeds;
        this.floor = floor;
        this.level = level;
        this.isActive = false;
    }

}
