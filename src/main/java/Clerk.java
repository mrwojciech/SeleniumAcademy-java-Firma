public class Clerk extends Employee {

    public static final String CLERK_JOB_TITLE = "Urzednik";
    static final double BASE_SALARY = 2000;
    double bonus;

    public Clerk(String name, double bonus) {
        super(name);
        this.bonus = bonus;
    }

    public double getSalaryOfEmployee() {
        return BASE_SALARY + BASE_SALARY * bonus;
    }

    @Override
    public String getEmployeeJobTitle() {
        return CLERK_JOB_TITLE;
    }

    @Override
    public String toString() {
        return "Nazwisko: " + super.getName()+ " Wypata: " + this.getSalaryOfEmployee();

    }

}
