public class Main {

    public static void main(String[] args) {
        doTask();
    }

    static void doTask() {
        Employee[] employees = acceptGroupOfEmployees(5);
        displayEmployeesOverAge(employees, 40);
    }

    static Employee[] acceptGroupOfEmployees(int number) {
        Employee[] employees = new Employee[number];
        employees[0] = new Employee("Petrov Petr", "director", "petrov@mail.ru", "(555) 325-95-85", 150000, 55);
        employees[1] = new Employee("Ivanov Ivan", "economist", "ivanov@mail.ru", "(555) 325-95-75", 120000, 35);
        employees[2] = new Employee("Sidorova Irina", "accountant", "sidorova@mail.ru", "(555) 325-95-55", 100000, 30);
        employees[3] = new Employee("Titova Maria", "cleaner", "titova@mail.ru", "(555) 325-95-60", 35000, 50);
        employees[4] = new Employee("Kotov Sergey", "driver", "kotov@mail.ru", "(555) 325-95-00", 65000, 25);
        return employees;
    }

    static void displayEmployeesOverAge(Employee[] employees, int age) {
        System.out.println(String.format("General information about employees over %d:", age));
        System.out.println();
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getAge() > age) {
                count++;
                System.out.print(count + ". ");
                employee.display();
            }
        }
    }

}
