package main.java.task3;

public class Room {
    private String name;
    private int numberOfPeople;
    private Door door;


    public Room(String name, int numberOfPeople, Door door) {
        this.name = name;
        this.numberOfPeople = numberOfPeople;
        this.door = door;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
}
