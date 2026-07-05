public class EmployeeManager {
    private Employee[] employees;
    private int size;
    private int capacity;

    public EmployeeManager(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (size >= capacity) {
            System.out.println("Array is full. Cannot add employee: " + employee.getName());
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employee.getEmployeeId()) {
                System.out.println("Employee with ID " + employee.getEmployeeId() + " already exists.");
                return false;
            }
        }
        employees[size] = employee;
        size++;
        System.out.println("Added: " + employee);
        return true;
    }

    public Employee searchById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverse() {
        if (size == 0) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("All Employees:");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                Employee removed = employees[i];
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                System.out.println("Deleted: " + removed);
                return true;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
