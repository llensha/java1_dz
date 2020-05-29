public class Dog extends Animal {

    public Dog(String name, String breed, String color, int age) {
        super(name, breed, color, age);
        setMaxLengthOfRun(500);
        setMaxLengthOfSwim(10);
        setMaxHeightOfJump(0.5);
    }

    public Dog(String name, String breed, String color, int age, int maxLengthOfRun) {
        super(name, breed, color, age, maxLengthOfRun);
        setMaxLengthOfSwim(10);
        setMaxHeightOfJump(0.5);
    }

    @Override
    public void run(int length) {
        if (length <= getMaxLengthOfRun()) {
            System.out.println(String.format("Dog %s runs %d m", getName(), length));
        } else {
            System.out.println(String.format("Dog %s can't run %d m", getName(), length));
        }
    }

    @Override
    public void swim(int length) {
        if (length <= getMaxLengthOfSwim()) {
            System.out.println(String.format("Dog %s is swimming %d m", getName(), length));
        } else {
            System.out.println(String.format("Dog %s can't swim %d m", getName(), length));
        }
    }

    @Override
    public void jump(double height) {
        if (height <= getMaxHeightOfJump()) {
            System.out.println(String.format("Dog %s jumps %.1f m", getName(), height));
        } else {
            System.out.println(String.format("Dog %s can't jump %.1f m", getName(), height));
        }
    }

}
