class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee[ID=" + employeeId + ", Name=" + name + ", Position=" + position + ", Salary=" + salary + "]";
    }
}

public class EmployeeManagement {
    private Employee[] employees;
    private int count;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
        } else {
            System.out.println("Employee list is full.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                employees[i] = employees[count - 1];
                employees[count - 1] = null;
                count--;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement(10);

        em.addEmployee(new Employee(1, "John Doe", "Developer", 50000));
        em.addEmployee(new Employee(2, "Jane Smith", "Manager", 60000));
        em.addEmployee(new Employee(3, "Emily Davis", "Designer", 55000));

        System.out.println("All Employees:");
        em.traverseEmployees();

        System.out.println("\nSearching for Employee with ID 2:");
        Employee emp = em.searchEmployee(2);
        System.out.println(emp != null ? emp : "Employee not found");

        System.out.println("\nDeleting Employee with ID 2:");
        em.deleteEmployee(2);
        em.traverseEmployees();
    }
}
