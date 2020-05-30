public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void fillThePlate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int appetite) {
        if (food >= appetite) {
            food -= appetite;
            return true;
        } else {
            System.out.println("Not enough food! Need to fill the plate");
            return false;
        }

    }

    public void info() {
        System.out.println("Amount of food in the plate: " + food);
    }

}
