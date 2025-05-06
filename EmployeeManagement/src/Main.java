import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Employee[] employees = new Employee[100];
    private static int counter = 0;
    private static int choice;

    public static void main(String[] args) {
        do {
            // Show Menu
            showMenu();
            // User Input
            System.out.print("Input Choice: ");
            choice = scanner.nextInt();
            // Process
            switch (choice) {
                case 1: {
                    addEmployee();
                    break;
                }
                case 2: {
                    viewEmployee();
                    break;
                }
                case 3: {
                    updateEmployee();
                    break;
                }
                case 4: {
                    deleteEmployee();
                    break;
                }
                case 5: {
                    Employee employee = searchEmployee();
                    if (employee != null) {
                        System.out.println("Employee Found!");
                        employee.show();
                    }
                    break;
                }
                case 6: {
                    sortEmployee();
                    break;
                }
                case 0: {
                    exitProgram();
                    break;
                }
                default: {
                    System.out.println("Invalid Choice!");
                }
            }
        } while (true);

    }

    private static void sortEmployee() {
        do {
            System.out.println("Sort Employee");
            System.out.println("1. by ID");
            System.out.println("2. by Name");
            System.out.println("3. by Salary");
            System.out.println("0. Back to the menu");

            System.out.print("Input Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    sortById();
                    return;
                }
                case 2: {
                    sortByName();
                    return;
                }
                case 3: {
                    sortBySalary();
                    return;
                }
                case 0: {
                    System.out.println("Back to the menu!");
                    break;
                }
                default: {
                    System.out.println("Invalid Choice!");
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void sortBySalary() {
        for (int i = 0; i < counter - 1; i++) {
            for (int j = 0; j < counter - 1; j++) {
                if (employees[j].salary < employees[j + 1].salary) {
                    Employee temp = employees[j + 1];
                    employees[j + 1] = employees[j];
                    employees[j] = temp;
                }
            }
        }
        System.out.println("Successfully Sorted by Salary!");
    }

    private static void sortByName() {
        for (int i = 0; i < counter - 1; i++) {
            for (int j = 0; j < counter - 1; j++) {
                if (Character.toLowerCase(employees[j].name.charAt(0)) > Character.toLowerCase(employees[j + 1].name.charAt(0))) {
                    Employee temp = employees[j + 1];
                    employees[j + 1] = employees[j];
                    employees[j] = temp;
                }
            }
        }
        System.out.println("Successfully Sorted by Name!");
    }

    private static void sortById() {
        for (int i = 0; i < counter - 1; i++) {
            for (int j = 0; j < counter - 1; j++) {
                if (employees[j].id > employees[j + 1].id) {
                    Employee temp = employees[j + 1];
                    employees[j + 1] = employees[j];
                    employees[j] = temp;
                }
            }
        }
        System.out.println("Successfully Sorted by ID!");
    }


    private static void deleteEmployee() {
        Employee employee = searchEmployee();
        if (employee != null) {
            do {
                employee.show();
                System.out.println("Are you sure you want to delete this employee?");
                System.out.println("1. Yes");
                System.out.println("0. No");
                System.out.print("Input Choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1: {
                        int index = -1;
                        for (int i = 0; i < counter; i++) {
                            if (employees[i] == employee) {
                                index = i;
                            }
                        }
                        for (int i = index; i < counter - 1; i++) {
                            employees[i] = employees[i + 1];
                        }
                        counter--;
                        System.out.println("Successfully Deleted Employee!");
                        return;
                    }
                    case 0: {
                        System.out.println("Okay! No Delete!");
                        break;
                    }
                    default: {
                        System.out.println("Invalid Choice!");
                        break;
                    }
                }
            } while (choice != 0);
        }
    }

    private static Employee searchEmployee() {
        do {
            int id;
            String name;

            System.out.println("Search Employee");
            System.out.println("1. by ID");
            System.out.println("2. by Name");
            System.out.println("0. Back to Menu");

            System.out.print("Input Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Input ID: ");
                    id = scanner.nextInt();
                    for (int i = 0; i < counter; i++) {
                        if (employees[i].id == id) {
                            return employees[i];
                        }
                    }
                    System.out.println("Employee Not Found!");
                    break;
                }
                case 2: {
                    name = scanner.nextLine();
                    System.out.print("Input Name: ");
                    name = scanner.nextLine();
                    for (int i = 0; i < counter; i++) {
                        if (employees[i].name.equalsIgnoreCase(name)) {
                            return employees[i];
                        }
                    }
                    System.out.println("Employee Not Found!");
                    break;
                }
                case 0: {
                    System.out.println("Back to the menu!");
                    break;
                }
                default: {
                    System.out.println("Invalid Choice!");
                    break;
                }
            }
        } while (choice != 0);
        return null;
    }

    private static void updateEmployee() {
        int id;
        String name;
        double salary;

        Employee employee = searchEmployee();
        if (employee != null) {
            System.out.print("Here is the employee: ");
            employee.show();
            System.out.print("Input new ID: ");
            id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Input new Name: ");
            name = scanner.nextLine();
            System.out.print("Input new Salary: ");
            salary = scanner.nextDouble();

            employee.id = id;
            employee.name = name;
            employee.salary = salary;
        }
    }

    private static void exitProgram() {
        System.out.println("Bye bye!");
        System.exit(0);
    }

    private static void viewEmployee() {
        System.out.println("View Employee");
        for (int i = 0; i < counter; i++) {
            employees[i].show();
        }
    }

    private static void addEmployee() {
        int id;
        String name;
        double salary;

        System.out.println("Add Employee");
        System.out.print("Input ID: ");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Input Name: ");
        name = scanner.nextLine();
        System.out.print("Input Salary: ");
        salary = scanner.nextDouble();

        Employee employee = new Employee(id, name, salary);
        employees[counter++] = employee;

        System.out.println("Successfully Added Employee!");
    }

    private static void showMenu() {
        System.out.println("Employee Management");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Search Employee");
        System.out.println("6. Sort Employee");
        System.out.println("0. Exit the program!");
    }
}