import java.util.Scanner;

public class Employee {
    public int id;
    public String name;
    public double salary;

    Employee() {
        this.id = 0;
        this.name = "unknown";
        this.salary = (double)0.0F;
    }

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void show() {
        System.out.println("ID: " + this.id + " Name: " + this.name + " Salary: " + this.salary);
    }

    public void getEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        this.id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        this.name = scanner.nextLine();
        System.out.print("Salary: ");
        this.salary = scanner.nextDouble();
    }

    public String toString() {
        return "Employee [id=" + this.id + ", name=" + this.name + ", salary=" + this.salary + "]";
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + this.id;
        result = 31 * result + (this.name == null ? 0 : this.name.hashCode());
        long temp = Double.doubleToLongBits(this.salary);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Employee other = (Employee)obj;
            if (this.id != other.id) {
                return false;
            } else {
                if (this.name == null) {
                    if (other.name != null) {
                        return false;
                    }
                } else if (!this.name.equals(other.name)) {
                    return false;
                }

                return Double.doubleToLongBits(this.salary) == Double.doubleToLongBits(other.salary);
            }
        }
    }
}
