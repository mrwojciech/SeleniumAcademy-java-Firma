import java.util.*;

public class StartApplication {


    public static final int MAX_CAPACITY = 99;

    public static void main(String[] args) {
        StartApplication startApplication = new StartApplication();
        startApplication.startApplication();
    }

    private void startApplication() {
        Map<String, Employee> listOfEmployee = new HashMap<>(99);
        createDB(listOfEmployee);
        Menu menu = new Menu(listOfEmployee);
        int instruction = 0;
        do {
            menu.showMenu();
            instruction = menu.takeInstructionNumber();
            if (instruction != 0) {
                menu.firstSubLevel(instruction);
            }
        } while (instruction != 0);
        System.out.println("Bye...");
    }

    private void createDB(Map<String, Employee> listOfEmployee) {
        listOfEmployee.put("Kowalski", new Clerk("Kowalski", 2));
        listOfEmployee.put("Polanski", new Clerk("Polanski", 2));
        listOfEmployee.put("Nowak", new Clerk("Nowak", 2));
        listOfEmployee.put("Sobasik", new Clerk("Sobasik", 2));
        listOfEmployee.put("Poniedzielski", new Clerk("Poniedzielski", 2));
        listOfEmployee.put("Kowalczyk", new Worker("Kowalczyk", Time.FULL, 22));
        listOfEmployee.put("Malinowski", new Worker("Malinowski", Time.HALF, 22));
        listOfEmployee.put("Baran", new Worker("Baran", Time.OVER, 22));
        listOfEmployee.put("Strozynski", new Worker("Strozynski", Time.HALF, 22));
        listOfEmployee.put("Terkowski", new Worker("Terkowski", Time.OVER, 22));
    }
}