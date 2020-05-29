public class Main {

    public static void main(String[] args) {
        doTask();
    }

    static void doTask() {
        Cat cat1 = new Cat("Trisha", "british blue", "blue", 2);
        Cat cat2 = new Cat("Baxter", "persian", "red", 5);
        Dog dog1 = new Dog("Lucky", "golden retriever", "gold", 3, 600);
        Dog dog2 = new Dog("Ava", "dachshund", "black", 4, 400);

        cat1.run(150);
        cat1.jump(1.5);
        System.out.println();
        cat2.run(250);
        cat2.swim(5);
        cat2.jump(3);
        System.out.println();
        dog1.run(500);
        dog1.swim(5);
        dog1.jump(0.3);
        System.out.println();
        dog2.run(500);
        dog2.swim(20);
        dog2.jump(1);
    }
}
