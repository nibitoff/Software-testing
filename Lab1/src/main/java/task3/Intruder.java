package main.java.task3;

public class Intruder extends Human{
    public String name;
    public boolean caughtStatus;

    public Intruder(String name, String gender, Room location, boolean isCaught) {
        this.name = name;
        this.gender = gender;
        this.location = location;
        this.caughtStatus = false;
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
