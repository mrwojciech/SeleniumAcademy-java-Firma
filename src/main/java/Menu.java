import java.util.Map;
import java.util.Scanner;

public class Menu {
    Map<String, Employee> listOfEmployee;
    final static int MAX_CAPACITY = StartApplication.MAX_CAPACITY;

    public Menu(Map<String, Employee> listOfEmployee) {
        this.listOfEmployee = listOfEmployee;
    }

    public static void showMenu() {
        {
            System.out.println();
            System.out.println("1 - obliczenie wypłaty Pracownika.");
            System.out.println("2 - znajdź Pracownika o podanym nazwisku ( wynikiem powinna być referencja do obiektu )");
            System.out.println("3 - czy Pracownik jest Urzędnikiem/ Robotnikiem)");
            System.out.println("4 - przyjmij nowego Urzędnika ");
            System.out.println("5 - przyjmij nowego Robotnika");
            System.out.println("6 - zwolnij pracownika o podanym nazwisku");
            System.out.println("7 - ilu jest zatrudnionych Urzędników ( Robotników )");
            System.out.println("8 - jaka jest suma wypłat wszystkich Urzędników ( Robotników)");
            System.out.println("9 - wydruk listy płac          itp. itd.");
            System.out.println("0 - koniec");
        }
    }

    public int takeInstructionNumber() {
        Scanner scanner = new Scanner(System.in);
        int instruction = scanner.nextInt();
        return instruction;
    }

    public String getName() {
        String name = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwisko: ");
        name = scanner.nextLine();
        return name;
    }

    public int firstSubLevel(int subMenu) {
        String name;
        switch (subMenu) {
            case 0:
                return 0;
            case 1:
                name = getName();
                listOfEmployee.containsKey(name);
                System.out.println("Wypłata tego pracownika to: " +
                        listOfEmployee.get(name).getSalaryOfEmployee());
                break;
            case 2:
                name = getName();
                System.out.println("Referencja do obiektu tego pracownika to:" + listOfEmployee.get(name));
                break;
            case 3:
                name = getName();
                System.out.println("Podany pracownik jest: " + listOfEmployee.get(name).getEmployeeJobTitle());
                break;

            case 4:
                if (listOfEmployee.size() < MAX_CAPACITY) {
                    System.out.println("Przyjmij Urzdnika: ");
                    name = getName();

                    listOfEmployee.put(name, getNewClerkData(name));
                } else {

                    System.out.println("Osiągnięto maxymalną liczbą pracowników. ");
                }
                break;
            case 5:
                if (listOfEmployee.size() < MAX_CAPACITY) {

                    System.out.println("Przyjmij Robotnika: ");
                    name = getName();
                    listOfEmployee.put(name, getNewWorkerData(name));
                } else {

                    System.out.println("Osiągnięto maxymalną liczbą pracowników. ");
                }
                break;
            case 6:
                name = getName();
                System.out.println("Pracownik zostal usuniety: ");
                listOfEmployee.remove(name);
                break;
            case 7:
                int workerCount = 0, clerkCount = 0;
                System.out.println("Jest zatrudnionych: ");
                for (String nameOfEmployee : listOfEmployee.keySet()) {
                    if (listOfEmployee.get(nameOfEmployee).getEmployeeJobTitle().equals(Worker.workerTitle)) {
                        workerCount++;
                    } else if (listOfEmployee.get(nameOfEmployee).getEmployeeJobTitle().equals(Clerk.CLERK_JOB_TITLE)) {
                        clerkCount++;
                    }
                }
                System.out.println("Robotnikw: " + workerCount);
                System.out.println("Urzednikow: " + clerkCount);
                break;
            case 8:
                int workersSalary = 0, clerksSalary = 0;
                for (String nameOfEmployee : listOfEmployee.keySet()) {
                    if (listOfEmployee.get(nameOfEmployee).getEmployeeJobTitle().equals(Worker.workerTitle)) {
                        workersSalary += listOfEmployee.get(nameOfEmployee).getSalaryOfEmployee();
                    } else if (listOfEmployee.get(nameOfEmployee).getEmployeeJobTitle().equals(Clerk.CLERK_JOB_TITLE)) {
                        clerksSalary += listOfEmployee.get(nameOfEmployee).getSalaryOfEmployee();
                    }
                }
                System.out.println("Suma wyplat:");
                System.out.println("Urzednikow: " + clerksSalary);
                System.out.println("Robotnikow: " + workersSalary);
                break;
            case 9:
                System.out.println("Wydruk pac wszystkich pracownikow: ");
                for (String nameOfEmployee : listOfEmployee.keySet()) {
                    System.out.println(listOfEmployee.get(nameOfEmployee).toString());
                }
                break;
            default :
                System.out.println("Podaj poprawną wartość.");
                break;
        }
        return -1;
    }

    private Worker getNewWorkerData(String name) {
        double rate;
        Integer timeInt;
        Scanner scanner = new Scanner(System.in);
        Time time = null;
        System.out.println("Jaka jest stawka godzinowa robotnika:");
        rate = scanner.nextDouble();
        System.out.println("Jaki jest etat:");
        System.out.println("1: FULL-TIME");
        System.out.println("2: PART-TIME");
        System.out.println("3: OVER-TIME");
        timeInt = scanner.nextInt();
        switch (timeInt) {

            case 1:
                time = Time.FULL;
                break;
            case 2:
                time = Time.HALF;
                break;
            case 3:
                time = Time.OVER;
                break;

        }


        Worker worker = new Worker(name, time, rate);

        return worker;
    }

    private Clerk getNewClerkData(String name) {
        double bonus;
        System.out.println("Jaki jest bonus urzednika:");
        Scanner scanner = new Scanner(System.in);
        bonus = scanner.nextDouble();
        Clerk clerk = new Clerk(name, bonus);
        return clerk;
    }
}