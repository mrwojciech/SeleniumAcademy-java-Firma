public abstract class Employee {

    private Time time;
    String name;

    public Time getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public Employee(String name, Time time) {
        this(name);
        this.time = time;
    }

    public Employee(String name) {
    this.name = name;
    }

    public abstract double getSalaryOfEmployee();

    public abstract String getEmployeeJobTitle();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
