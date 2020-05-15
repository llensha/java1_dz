import java.util.Arrays;
import java.util.Scanner;

public class MainDZ2 {

    public static void main(String[] args) {

        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("Задание 1:");
        int[] arrayBinary = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for(int i=0; i<arrayBinary.length; i++) {
            if (arrayBinary[i] == 0) {
                arrayBinary[i] = 1;
            } else {
                arrayBinary[i] = 0;
            }
            System.out.print(arrayBinary[i] + " ");
        }
        System.out.println();

        // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("Задание 2:");
        int[] arrayAddThree = new int[8];
        int count = 0;
        int value = 0;
        while (count < arrayAddThree.length) {
            arrayAddThree[count] = value;
            value += 3;
            count++;
        }
        System.out.println(Arrays.toString(arrayAddThree));

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("Задание 3:");
        int[] arrayDoubling = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i=0; i<arrayDoubling.length; i++) {
            if(arrayDoubling[i] < 6) {
                arrayDoubling[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arrayDoubling));

        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("Задание 4:");
        int[][] arrayDiagonal = new int[5][5];
        for(int i=0; i<5; i++) {
            arrayDiagonal[i][i] = i * 2 + 1;
            System.out.println(Arrays.toString(arrayDiagonal[i]));
        }

        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("Задание 5:");
        int[] arrayMinMax = makeNewArray(10, 1000, 500);
        int minValue = findMinValue(arrayMinMax);
        System.out.println("Минимальное значение = " + minValue);
        int maxValue = findMaxValue(arrayMinMax);
        System.out.println("Максимальное значение = " + maxValue);

        // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        // если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.
        System.out.println("Задание 6:");
        Scanner scanner = new Scanner(System.in);
        String isOneMoreTask6;
        do {
            int[] arrayBalance = makeNewArray(10,5,0);
            boolean isBalance = checkBalance(arrayBalance);
            System.out.println(isBalance);
            System.out.println("Попробовать еще раз? [y/n]");
            isOneMoreTask6 = scanner.next();
        } while (isOneMoreTask6.equals("y"));

        // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        // при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        System.out.println("Задание 7:");
        String isOneMoreTask7;
        do {
            int[] arrayStart = makeNewArray(20,100,0);
            int n = (int) (Math.random() * 20 - 10);
            int[] arrayFinal = moveArray(arrayStart, n);
            System.out.println("Результат сдвига на " + n + " позиций:");
            System.out.println(Arrays.toString(arrayFinal));
            System.out.println("Попробовать еще раз? [y/n]");
            isOneMoreTask7 = scanner.next();
        } while (isOneMoreTask7.equals("y"));

    }

    static int[] makeNewArray(int length, int n, int m) {
        int[] arr = new int[length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = (int) (Math.random() * n - m);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    static int findMinValue(int[] arr) {
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int i : arr
        ) {
            if (i < minValue) {
                minValue = i;
            }
        }
        return minValue;
    }

    static int findMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int i : arr
        ) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    static boolean checkBalance (int[] arrayBalance) {
        int sumLeft = 0;
        int sumRight;
        for(int i=0; i<arrayBalance.length-1; i++) {
            sumLeft += arrayBalance[i];
            sumRight = 0;
            for(int j=arrayBalance.length-1; j>i; j--) {
                sumRight += arrayBalance[j];
            }
            if (sumLeft == sumRight) {
                System.out.println("Сумма = " + sumLeft + " до позиции " + i);
                return true;
            }
        } return false;
    }

    static int[] moveArray(int[] arr, int n) {
        if (n > 0) {
            for (int i = arr.length - 1; i>=0; i--) {
                if (i > n - 1) {
                    int j = i - n;
                    arr[i] = arr[j];
                } else {
                    arr[i] = 0;
                }
            }
        } else if (n < 0) {
            for(int i = 0; i<arr.length; i++) {
                if (i < arr.length+n) {
                    int j = i - n;
                    arr[i] = arr[j];
                } else {
                    arr[i] = 0;
                }
            }
        }
        return arr;
    }
    
    }

