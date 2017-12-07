public class Worker extends Employee {


    public static String WORKER_TITLE = "Robotnik";
    private double hourRate = 1.5;
//    Time time;
    private double BONUS_RATE = 1.5;
    private String robotnik;


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
        switch (super.getTime()) {
            case HALF:
                salary = Time.HALF.counter * hourRate;
                break;
            case FULL:
                salary = Time.FULL.counter * hourRate;
                break;
            case OVER:
                salary = ((Time.FULL.counter * hourRate) +
                        (Time.OVER.counter - Time.FULL.counter) * hourRate * BONUS_RATE);
                break;

        }
        return salary;
    }

    @Override
    public String getEmployeeJobTitle() {
        return WORKER_TITLE;
    }

    @Override
    public String toString() {
        return "Nazwisko: " + super.getName()+ " Wypata: " + this.getSalaryOfEmployee();
    }
}
