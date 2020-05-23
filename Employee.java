public class Employee {

    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void display() {
        System.out.println(String.format("Employee: %s, age: %d", fullName, age));
        System.out.println(String.format("position: %s, salary: %d", position, salary));
        System.out.println(String.format("phone: %s, email: %s", phone, email));
        System.out.println();
    }
}
