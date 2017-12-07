public class Clerk extends Employee {

    public static final String CLERK_JOB_TITLE = "Urzednik";
    static final double baseSalary = 2000;
    double bonus;

    public Clerk(String name, double bonus) {
        super(name);
        this.bonus = bonus;
    }

    public double getSalaryOfEmployee() {
        return baseSalary + baseSalary * bonus;
    }

    @Override
    public String getEmployeeJobTitle() {
        return CLERK_JOB_TITLE;
    }

    @Override
    public String toString() {
        return "Nazwisko: " + getName() + " Wypata: " + getSalaryOfEmployee();
    }
}
