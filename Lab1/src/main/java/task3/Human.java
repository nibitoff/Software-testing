package main.java.task3;

public class Human {
    public String gender;
    public String bodyPart;
    public String emotions;
    public String job;
    public Room location;

    public Human() {
    }

    public void openDoor(Door door){
        door.setStatus(true);
        System.out.println( "Door is opened");
    }
    public void closeDoor(Door door){
        door.setStatus(false);
        System.out.println("Door is closed");
    }

    public void changeLocation(Room roomFrom, Room roomTo){
        roomFrom.setNumberOfPeople(roomFrom.getNumberOfPeople() - 1);
        roomTo.setNumberOfPeople(roomTo.getNumberOfPeople() + 1);
        this.location = roomTo;
    }

    public String getGender() {
        return gender;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public String getEmotions() {
        return emotions;
    }

    public String getJob() {
        return job;
    }
}
