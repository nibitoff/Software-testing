package main.java.task3;

import java.util.ArrayList;
import java.util.Objects;

public class Security extends Human{
    private ArrayList<Intruder> caughtIntruders = new ArrayList<>();
    public Security(String name,  String emotion, Room location){
        super(name, emotion, location);
    }

    public void catchIntruders(Intruder intruder){
        if (!intruder.isCaught()) {
            intruder.setCaught(true);
            caughtIntruders.add(intruder);
            System.out.println("[intruder] " + intruder.name + " is caught by [security] " + this.name +  "!");
        } else System.out.println( "[intruder] " +  intruder.name + " is already caught by [security] " + this.name + ".");
    }

    public void moveSomebody(String nameHuman, Room from, Room to) {
        if (!caughtIntruders.isEmpty()) {
            for (Intruder i : this.caughtIntruders) {
                if (Objects.equals(i.getName(), nameHuman) && this.getLocation() == from) {
                    i.changeLocation(from, to);
                    this.changeLocation(from, to);
                    System.out.println("[security] " + this.name + " moved [intruder] " + nameHuman + " to [room] " + to.getName() + ".");
                }
            }
        }
    }
}
