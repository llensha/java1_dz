import java.util.Random;
import java.util.Scanner;

public class MainDZ4 {

    /**
     * Tic Tac Toe
     * <p>
     * 1. Инициализровать игровое поле
     * 2. Игрок - Х, Компьютер - О
     * 3. Игрок всегда ходит первый
     * 4. Реализовать ход игрока по координатам [X, Y]
     * 5. Реализовать ход компьютера по координатам [X, Y]
     * 6. Защита от неверных координат [X, Y] введенных игроком
     * 7. Защита от попытки ввести координаты [X, Y] в уже занятую ячейку
     * 8. Игра до победы
     * 9. Проверка победы
     * 10. Победа
     * 11. Проверка ничьи TODO
     */

    public static void main(String[] args) {
        playTicTacToe();
    }

    static void playTicTacToe() {
        int size = 5;
        int winSize = 4;
        char playerSign = 'X';
        char computerSign = 'O';
        char emptySign = '•';
        char currentPlayerSign = playerSign;

        char[][] field = getField(size, emptySign);
        drawField(field);

        boolean isEnd;
        do {
            move(field, winSize, currentPlayerSign, playerSign, computerSign, emptySign);
            drawField(field);
            isEnd = checkEnd(field, winSize, currentPlayerSign, playerSign, emptySign);

            if (!isEnd) {
                currentPlayerSign = currentPlayerSign == playerSign ? computerSign : playerSign;
            }
        } while(!isEnd);

        System.out.println("Игра окончена");
    }

    static char[][] getField(int size, char emptySign) {
        char[][] field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = emptySign;
            }
        }
        return field;
    }

    static void drawField(char[][] field) {
        for (int i = -1; i < field.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < field.length; j++) {
                if (i == -1) {
                    System.out.print((j + 1) + " ");
                } else {
                    System.out.print(field[i][j] + " " );
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static void move(char[][] field, int winSize, char currentPlayerSign, char playerSign, char computerSign, char emptySign) {
        if (currentPlayerSign == playerSign) {
            movePlayer(field, currentPlayerSign, playerSign, emptySign);
        } else {
            moveComputer(field, winSize, currentPlayerSign, playerSign, computerSign, emptySign);
        }
    }

    static void movePlayer(char[][] field, char currentPlayerSign, char playerSign, char emptySign) {
        int x;
        int y;

        boolean isCellValid;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println(String.format("Input Y-coordinate [from 1 till %d]", field.length));
            y = scanner.nextInt() - 1;
            System.out.println(String.format("Input X-coordinate [from 1 till %d]", field.length));
            x = scanner.nextInt() - 1;

            isCellValid = validateCell(field, emptySign, currentPlayerSign, playerSign, y, x);

        } while (!isCellValid);

        field[y][x] = playerSign;
    }

    static void moveComputer(char[][] field, int winSize, char currentPlayerSign, char playerSign, char computerSign, char emptySign) {
        int x = -1;
        int y = -1;
        boolean isMove = false;
        Random random = new Random();

        if (validateCell(field, emptySign, currentPlayerSign, playerSign, field.length/2, field.length/2)) {
            y = field.length/2;
            x = field.length/2;
            isMove = true;
        }
        if (!isMove) {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    if (validateCell(field, emptySign, currentPlayerSign, playerSign, i, j)) {
                        x = j;
                        y = i;
                        field[y][x] = computerSign;
                        if (checkWin(field, winSize, computerSign)) {
                            isMove = true;
                            break;
                        } else {
                            field[y][x] = emptySign;
                        }
                    }
                }
                if (isMove) break;
            }
        }

        if (!isMove) {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    if (validateCell(field, emptySign, currentPlayerSign, playerSign, i, j)) {
                        x = j;
                        y = i;
                        field[y][x] = playerSign;
                        if (checkWin(field, winSize, playerSign)) {
                            field[y][x] = computerSign;
                            isMove = true;
                            break;
                        } else {
                            field[y][x] = emptySign;
                        }
                    }
                }
                if (isMove) break;
            }
        }

        if (!isMove) {
            int sum = 0;
            for(int i=0; i<field.length; i++) {
                for (int j=0; j<field.length; j++) {
                    if (validateCell(field, emptySign, currentPlayerSign, playerSign, i, j)) {
                        int currentSum = checkPriority(field, computerSign, playerSign, i, j);
                        if (currentSum > sum) {
                            x = j;
                            y = i;
                            sum = currentSum;
                            isMove = true;
                        }
                    }
                }
            }
        }

        if (!isMove) {
            for (int i = 0; i < field.length; i++) {
                if(validateCell(field, emptySign, currentPlayerSign, playerSign, i, i)) {
                    x = i;
                    y = i;
                    isMove = true;
                    break;
                }
                if(validateCell(field, emptySign, currentPlayerSign, playerSign, i, field.length-i-1)) {
                    x = field.length-i-1;
                    y = i;
                    isMove = true;
                    break;
                }
            }
        }

        if (!isMove) {
            do {
                y = random.nextInt(field.length);
                x = random.nextInt(field.length);
            } while (!validateCell(field, emptySign, currentPlayerSign, playerSign, y, x));
        }

        System.out.println(String.format("Computer decided choose coordinates [%d, %d]", y + 1, x + 1));
        field[y][x] = computerSign;
    }

    static int checkPriority(char[][] field, char computerSign, char playerSign, int y, int x) {
        int sum = 0;
        for (int i=0; i<field.length; i++) {
            if (field[y][i] == computerSign) sum++; else if (field[y][i] == playerSign) sum--;
            if (field[i][x] == computerSign) sum++; else if (field[i][x] == playerSign) sum--;
            if (y == x) {
                if (field[i][i] == computerSign) sum++; else if (field[i][i] == playerSign) sum--;
            }
            if (y == field.length-x-1) {
                if (field[i][field.length-i-1] == computerSign) sum++; else if (field[i][field.length-i-1] == playerSign) sum--;
            }
        }
        for(int i=0; i<field.length-Math.abs(y-x); i++) {
            if (y > x) {
                if (field[i + (y - x)][i] == computerSign) sum++;
                else if (field[i + (y - x)][i] == playerSign) sum--;
            }
            if (y < x) {
                if (field[i][i + (x - y)] == computerSign) sum++;
                else if (field[i][i + (x - y)] == playerSign) sum--;
            }
        }
        for(int i=0; i<field.length-Math.abs(y-(field.length-x-1)); i++) {
            if (y > field.length-x-1) {
                if (field[i+(y-(field.length-x-1))][field.length-i-1] == computerSign) sum++;
                else if (field[i+(y-(field.length-x-1))][field.length-i-1] == playerSign) sum--;
            }
            if (y < field.length-x-1) {
                if (field[i][x+y-i] == computerSign) sum++; else if (field[i][x+y-i] == playerSign) sum--;
            }
        }
        return sum;
    }

    static boolean validateCell(char[][] field, char emptySign, char currentPlayerSign, char playerSign, int y, int x) {
        boolean result = true;

        if (x < 0 || x >= field.length || y < 0 || y >= field.length) {
            if (currentPlayerSign == playerSign) {
                System.out.println(String.format("Input coordinates are incorrect. Available coordinates in range from 1 till %d", field.length));
            }
            result = false;
        } else if (field[y][x] != emptySign) {
            if (currentPlayerSign == playerSign) {
                System.out.println(String.format("Input coordinates are incorrect. Cell of coordinates [%d, %d] is already occupied", y+1, x+1));
            }
            result = false;
        }
        return result;
    }

    static boolean checkEnd(char[][] field, int winSize, char currentPlayerSign, char playerSign, char emptySign) {

        if (checkWin(field, winSize, currentPlayerSign)) {
            String currentPlayerName = currentPlayerSign == playerSign ? "Player" : "Computer";
            System.out.println(String.format("Congrats!!! You are The Winner, Mr. %s", currentPlayerName));
            return true;
        }
        if (checkFieldFull(field, emptySign)){
            System.out.println("Ничья");
            return true;
        }
        return false;
    }

    static boolean checkWin(char[][] field, int winSize, char currentPlayerSign) {
        if (checkStraightWin(field, winSize, currentPlayerSign)) {
            return true;
        }
        if (checkDiagonalWin(field, winSize, currentPlayerSign)) {
            return true;
        }
        return false;
    }

    static boolean checkStraightWin(char[][] field, int winSize, char currentPlayerSign) {
        int sumX = 0;
        int sumY = 0;
        for(int i=0; i<field.length; i++) {
            sumX = 0;
            sumY = 0;
            for(int j=0; j<field.length; j++) {
                if(field[i][j] == currentPlayerSign) sumX++; else sumX = 0;
                if(field[j][i] == currentPlayerSign) sumY++; else sumY = 0;
                if (sumX == winSize || sumY == winSize) return true;
            }
        }
        return false;
    }

    static boolean checkDiagonalWin(char[][] field, int winSize, char currentPlayerSign) {
        int sumDRX = 0;
        int sumDRY = 0;
        int sumDBX = 0;
        int sumDBY = 0;

        for(int x=0; x<=field.length-winSize; x++) {
            sumDRX = 0;
            sumDRY = 0;
            sumDBX = 0;
            sumDBY = 0;
            for(int i=0; i<field.length-x; i++) {
                if (field[i][i+x] == currentPlayerSign) sumDRX++; else sumDRX = 0;
                if (field[i+x][i] == currentPlayerSign) sumDRY++; else sumDRY = 0;
                if (field[i][field.length-i-1-x] == currentPlayerSign) sumDBX++; else sumDBX = 0;
                if (field[i+x][field.length-i-1] == currentPlayerSign) sumDBY++; else sumDBY = 0;
                if (sumDRX == winSize || sumDRY == winSize || sumDBX == winSize || sumDBY == winSize) return true;
            }
        }
        return false;
    }

    public static boolean checkFieldFull(char[][] field, char emptySign) {
        for (int i = 0; i < field.length; i ++) {
            for (int j = 0; j < field.length; j ++) {
                if (field[i][j] == emptySign) return false;
            }
        }
        return true;
    }

}
