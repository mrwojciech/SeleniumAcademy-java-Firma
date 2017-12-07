public class Worker extends Employee {

    public static String workerTitle = "Robotnik";
    private double hourRate = 1.5;
    private double bonusRate = 1.5;

    public Worker(String name, Time time, double hourRate) {
        super(name, time);
        this.hourRate = hourRate;
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    public double getSalaryOfEmployee() {
        double salary = 0;
        switch (getTime()) {
            case HALF:
                salary = Time.HALF.counter * hourRate;
                break;
            case FULL:
                salary = Time.FULL.counter * hourRate;
                break;
            case OVER:
                salary = ((Time.FULL.counter * hourRate) +
                        (Time.OVER.counter - Time.FULL.counter) * hourRate * bonusRate);
                break;

        }
        return salary;
    }

    @Override
    public String getEmployeeJobTitle() {
        return workerTitle;
    }

    @Override
    public String toString() {
        return "Nazwisko: " + getName() + " Wypata: " + getSalaryOfEmployee();
    }
}