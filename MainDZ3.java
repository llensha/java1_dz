import java.util.Arrays;
import java.util.Scanner;

public class MainDZ3 {

    public static void main(String[] args) {

        System.out.println("Задание 1:");
        guessTheNumber(0, 9, 3);

        System.out.println("Задание 2:");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                          "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                          "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        guessTheWord(words);

    }

    static void guessTheNumber(int minNumber, int maxNumber, int shots) {
        Scanner scanner = new Scanner(System.in);
        byte isOneMoreRound;
        do {
            System.out.printf("Угадайте число от %d до %d. У вас %d попытки \n", minNumber, maxNumber, shots);
            int guessedNumber = (int) (Math.random() * (maxNumber - minNumber + 1) + minNumber);
            for(int i=1; i<=shots; i++) {
                System.out.printf("Попытка %d. Введите число: ", i);
                int estimatedNumber = scanner.nextInt();
                if (estimatedNumber == guessedNumber) {
                    System.out.println("Поздравляем! Вы угадали!");
                    break;
                } else if (estimatedNumber > guessedNumber) {
                    System.out.println("Загаданное число меньше");
                } else {
                    System.out.println("Загаданное число больше");
                }
            }
            System.out.println("Игра окончена");
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет:");
            isOneMoreRound = scanner.nextByte();
        } while (isOneMoreRound == 1);
    }

    static void guessTheWord(String[] words) {
        Scanner scanner = new Scanner(System.in);
        byte isOneMoreRound;
        do {
            System.out.println("Угадайте загаданное слово из списка:");
            System.out.println(Arrays.toString(words));
            String guessedWord = words[(int) (Math.random() * words.length)];
            char[] prompt = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};
            int shot = 1;
            while(true) {
                System.out.printf("Попытка %d. Введите слово: ", shot);
                String estimatedWord = scanner.next();
                if (estimatedWord.equals(guessedWord)) {
                    System.out.println("Поздравляем! Вы угадали!");
                    break;
                } else {
                    System.out.println("Вы не угадали");
                    System.out.print("Подсказка! Совпадающие буквы: ");
                    for(int i=0; i<prompt.length; i++) {
                        if(i<guessedWord.length() && i<estimatedWord.length() && estimatedWord.charAt(i)==guessedWord.charAt(i)) {
                            System.out.print(estimatedWord.charAt(i));
                        } else {
                            System.out.print(prompt[i]);
                        }
                    }
                    System.out.println();
                }
                shot++;
            }
            System.out.println("Игра окончена");
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет:");
            isOneMoreRound = scanner.nextByte();
        } while (isOneMoreRound == 1);
    }

}
