package main.java.task3;

import java.util.ArrayList;

public class Security extends Human{
    private ArrayList<Intruder> caughtIntruders = new ArrayList<>();
    public Security(String gender, Room location){
        this.gender = gender;
        this.location = location;
    }


    public String catchIntruders(Intruder intruder){
        if (!intruder.isCaught()) {
            intruder.setCaught(true);
            caughtIntruders.add(intruder);
            return "Intruder " + intruder.name + "is caught by security!";
        }
        return "This intruder " +  intruder.name + "is already caught.";
    }

    public void moveSomebody(String nameHuman, Room from, Room to) {
        if (!caughtIntruders.isEmpty()) {
            for (Intruder i : this.caughtIntruders) {
                if (i.getName() == nameHuman) {
                    i.changeLocation(from, to);
                }
            }
        }
    }
}
