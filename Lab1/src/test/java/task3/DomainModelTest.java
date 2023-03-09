package test.java.task3;

import main.java.task3.*;
import org.junit.jupiter.api.*;

import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DomainModelTest {
    private HashMap<String, Room> rooms;
    private HashMap<String, Human> people;
    private Notebook book;
    private Door door;

    @BeforeAll
    public void initAll() {
        door = new Door(false);
        book = new Notebook(false, 2, 100);
        rooms = new HashMap<>();
        people = new HashMap<>();

        rooms.put("Cabin", new Room("Cabin", 0, door));
        rooms.put("Bridge", new Room("Bridge", 0, door));
        rooms.put("Strange Room", new Room("Rum Storage", 0, door));

        people.put("captain", new Captain("Jack Sparrow", "neutral", rooms.get("Bridge")));
        people.put("intruder1", new Intruder("William",  "neutral", rooms.get("Bridge")));
        people.put("intruder2", new Intruder("Barbossa", "neutral", rooms.get("Bridge")));
        people.put("security", new Security("Gibbs", "neutral", rooms.get("Bridge")));
        rooms.get("Bridge").setNumberOfPeople(4);

    }

    @Test
    public void testBadLocationChange() {
        Human person = people.get("captain");

        int t = rooms.get("Bridge").getNumberOfPeople();
        person.openDoor(door);
        person.changeLocation(rooms.get("Cabin"), rooms.get("Strange Room"));
        person.closeDoor(door);

        Assertions.assertEquals(rooms.get("Cabin").getNumberOfPeople(), 0);
        Assertions.assertEquals(rooms.get("Bridge").getNumberOfPeople(), t);
    }

    @Test
    public void testCLosedDoorLocationChange() {
        Human person = people.get("captain");

        int t = rooms.get("Bridge").getNumberOfPeople();
        person.changeLocation(rooms.get("Bridge"), rooms.get("Cabin"));

        Assertions.assertEquals(rooms.get("Cabin").getNumberOfPeople(), 0);
        Assertions.assertEquals(rooms.get("Bridge").getNumberOfPeople(), t);
    }

    @Test
    public void testGoodLocationChange() {
        Human person = people.get("intruder1");

        int t = rooms.get("Bridge").getNumberOfPeople();
        person.openDoor(rooms.get("Bridge").getDoor());
        person.changeLocation(rooms.get("Bridge"), rooms.get("Cabin"));
        person.closeDoor(rooms.get("Bridge").getDoor());

        Assertions.assertEquals(rooms.get("Cabin").getNumberOfPeople(), 1);
        Assertions.assertEquals(rooms.get("Bridge").getNumberOfPeople(), t - 1);
        Assertions.assertEquals(person.getLocation().getName(), "Cabin");
        person.openDoor(rooms.get("Bridge").getDoor());
        person.changeLocation(rooms.get("Cabin"), rooms.get("Bridge"));
        person.closeDoor(rooms.get("Bridge").getDoor());
    }

    @Test
    public void testSecurityCatching() {
        Security security = (Security) people.get("security");
        Intruder intruder1 = (Intruder) people.get("intruder1");
        Intruder intruder2 = (Intruder) people.get("intruder2");
        Room bridge = rooms.get("Bridge");
        Room cabin = rooms.get("Cabin");

        int t = bridge.getNumberOfPeople();

        security.openDoor(bridge.getDoor());
        security.catchIntruders(intruder1);
        security.moveSomebody(intruder1.getName(), bridge, cabin);
        Assertions.assertEquals(bridge.getNumberOfPeople(), t - 2);
        Assertions.assertEquals(cabin.getNumberOfPeople(), 2);
        System.out.println();

        security.changeLocation(cabin, bridge);
        security.catchIntruders(intruder2);
        security.moveSomebody(intruder2.getName(), bridge, cabin);
        Assertions.assertEquals(cabin.getNumberOfPeople(), 3);
        Assertions.assertEquals(bridge.getNumberOfPeople(), t - 3);
    }

    @Test
    public void testFlipClosedBook() {
        Captain cap = (Captain) people.get("captain");

        int prevPage = book.getCurrentPage();
        cap.flipPages(book, 40);
        Assertions.assertEquals(book.getCurrentPage(), prevPage);
    }

    @Test
    public void testFlipBadPageOpenedBook() {
        Captain cap = (Captain) people.get("captain");

        int prevPage = book.getCurrentPage();
        cap.openBook(book);
        cap.flipPages(book, 4000);
        Assertions.assertEquals(book.getCurrentPage(), prevPage);
    }

    @Test
    public void testGoodFlipOpenedBook() {
        Captain cap = (Captain) people.get("captain");

        int newPage = 39;
        cap.openBook(book);
        cap.flipPages(book, newPage);
        Assertions.assertEquals(book.getCurrentPage(), newPage);
    }

    @AfterEach
    public void printSep(){
        System.out.println("---------------------------------------------");
    }
}
