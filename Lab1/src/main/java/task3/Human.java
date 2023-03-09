package main.java.task3;

public class Human {
    public String name;
    public String emotions;
    public Room location;

    public Human() {
    }

    public Human(String name, String emotions, Room location) {
        this.name = name;
        this.emotions = emotions;
        this.location = location;
    }

    public void openDoor(Door door){
        door.setOpened(true);
        System.out.println("Door is opened.");
    }
    public void closeDoor(Door door){
        door.setOpened(false);
        System.out.println("Door is closed.");
    }

    public void changeLocation(Room roomFrom, Room roomTo){
        if(location == roomFrom && roomFrom.getDoor().isOpened()){
            roomFrom.setNumberOfPeople(roomFrom.getNumberOfPeople() - 1);
            roomTo.setNumberOfPeople(roomTo.getNumberOfPeople() + 1);
            this.location = roomTo;
            System.out.println("[human] " + this.name + " changed location: " + roomFrom.getName()  + " -> " + roomTo.getName() + ".");
        }
        System.out.println("Current [human] " + this.name + "'s location is " + this.getLocation().getName() + ".");
    }

    public String getEmotions() {
        return emotions;
    }

    public String getName() {
        return name;
    }

    public Room getLocation() {
        return location;
    }
}
