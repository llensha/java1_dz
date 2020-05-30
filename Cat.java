import java.util.Scanner;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate plate) {
        boolean isOneMore;
        do {
            isOneMore = false;
            System.out.println(String.format("Feed the cat %s. It's appetite is %d", name, appetite));
            plate.info();
            satiety = plate.decreaseFood(appetite);
            System.out.println(String.format("Cat's %s satiety is %b", name, satiety));
            System.out.println();
            if (!satiety) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Fill the plate with food? [y/n]: ");
                String isFill = scanner.next();
                if (isFill.equals("y")) {
                    plate.fillThePlate(appetite);
                    isOneMore = true;
                }
            }
        } while (isOneMore);
    }

}
