package main.java.task3;

public class Intruder extends Human{
    public boolean caughtStatus;

    public Intruder(String name, String emotion, Room location){
        super(name, emotion, location);
    }

    public Intruder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCaught() {
        return caughtStatus;
    }

    public void setCaught(boolean caughtStatus) {
        this.caughtStatus = caughtStatus;
    }

}
