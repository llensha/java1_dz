public abstract class Animal {
    private String name;
    private String breed;
    private String color;
    private int age;
    private int maxLengthOfRun;
    private int maxLengthOfSwim;
    private double maxHeightOfJump;

    public Animal(String name, String breed, String color, int age) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.age = age;
    }

    public Animal(String name, String breed, String color, int age, int maxLengthOfRun) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.age = age;
        this.maxLengthOfRun = maxLengthOfRun;
    }

    public String getName() {
        return name;
    }

    public int getMaxLengthOfRun() {
        return maxLengthOfRun;
    }

    public void setMaxLengthOfRun(int maxLengthOfRun) {
        this.maxLengthOfRun = maxLengthOfRun;
    }

    public int getMaxLengthOfSwim() {
        return maxLengthOfSwim;
    }

    public void setMaxLengthOfSwim(int maxLengthOfSwim) {
        this.maxLengthOfSwim = maxLengthOfSwim;
    }

    public double getMaxHeightOfJump() {
        return maxHeightOfJump;
    }

    public void setMaxHeightOfJump(double maxHeightOfJump) {
        this.maxHeightOfJump = maxHeightOfJump;
    }

    public abstract void run(int length);

    public abstract void swim(int length);

    public abstract void jump(double height);

}