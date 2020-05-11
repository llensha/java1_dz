import java.util.Scanner;

public class Main {

    // Java 1. Lesson 1. DZ

    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();

    public static void main(String[] args) {

        // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte b2 = 7;
        short s2 = 777;
        int i2 = 77777;
        long l2 = 7777777777L;
        float f2 = 25.35f;
        double d2 = 5678.95;
        char c2 = 'Y';
        boolean bl2 = true;
        String str2 = "Text";

        // 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        // где a, b, c, d – входные параметры этого метода;
        float a = 3;
        float b = 5.5f;
        float c = 7;
        float d = 2;
        float value = calc(a, b, c, d);
        System.out.println("Задание 3");
        System.out.println("Выражение a * (b + (c / d)) = " + value);

        // 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
        // если да – вернуть true, в противном случае – false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 4");
        System.out.println("Введите целое число:");
        int num1 = scanner.nextInt();
        System.out.println("Введите еще одно целое число:");
        int num2 = scanner.nextInt();
        boolean isRange = range(num1, num2);
        if (isRange) {
            System.out.println("Сумма введенных чисел лежит в пределах от 10 до 20");
        } else {
            System.out.println("Сумма введенных чисел не входит в предел от 10 до 20");
        }

        // 5. Написать метод, которому в качестве параметра передается целое число,
        // метод должен напечатать в консоль положительное ли число передали, или отрицательное;
        // Замечание: ноль считаем положительным числом.
        System.out.println("Задание 5");
        System.out.println("Введите целое число:");
        int num5 = scanner.nextInt();
        positive(num5);

        // 6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
        System.out.println("Задание 6");
        System.out.println("Введите целое число:");
        int num6 = scanner.nextInt();
        boolean isNegative = negative(num6);
        System.out.println(isNegative);

        // 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
        // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        System.out.println("Задание 7");
        System.out.println("Введите ваше имя:");
        String yourName = scanner.next();
        printYourName(yourName);

        // 8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        System.out.println("Задание 8");
        System.out.println("Введите год:");
        int year = scanner.nextInt();
        check(year);

    }

    static float calc(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    static boolean range(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    static void positive(int a) {
        if (a >= 0) {
            System.out.println("Введенное число положительно");
        } else {
            System.out.println("Введенное число отрицательно");
        }
    }

    static boolean negative(int a) {
        return a < 0;
    }

    static void printYourName(String yourName) {
        System.out.println("Привет, " + yourName + "!");
    }

    static void check(int year) {
        if (year%4 == 0 && year%100 != 0 || year%400 == 0) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }
}
