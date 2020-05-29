public class Cat extends Animal {

    public Cat(String name, String breed, String color, int age) {
        super(name, breed, color, age);
        setMaxLengthOfRun(200);
        setMaxLengthOfSwim(0);
        setMaxHeightOfJump(2);
    }

    public Cat(String name, String breed, String color, int age, int maxLengthOfRun) {
        super(name, breed, color, age, maxLengthOfRun);
        setMaxLengthOfSwim(0);
        setMaxHeightOfJump(2);
    }

    @Override
    public void run(int length) {
        if (length <= getMaxLengthOfRun()) {
            System.out.println(String.format("Cat %s runs %d m", getName(), length));
        } else {
            System.out.println(String.format("Cat %s can't run %d m", getName(), length));
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("The cat cannot swim");
    }

    @Override
    public void jump(double height) {
        if (height <= getMaxHeightOfJump()) {
            System.out.println(String.format("Cat %s jumps %.1f m", getName(), height));
        } else {
            System.out.println(String.format("Cat %s can't jump %.1f m", getName(), height));
        }
    }

}
