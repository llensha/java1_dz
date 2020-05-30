public class Main {

    public static void main(String[] args) {

        doTask();

    }

    static void doTask() {
        Cat[] catsFamily = lodgeTheCatsFamily(5);
        Plate plate = new Plate(75);
        feedTheCatsFamily(catsFamily, plate);
    }

    static Cat[] lodgeTheCatsFamily(int number) {
        Cat[] catsFamily = new Cat[number];
        catsFamily[0] = new Cat("Baxter", 25);
        catsFamily[1] = new Cat("Trisha", 22);
        catsFamily[2] = new Cat("Lucky", 15);
        catsFamily[3] = new Cat("Ava", 10);
        catsFamily[4] = new Cat("Kitty", 5);
        return catsFamily;
    }

    static void feedTheCatsFamily(Cat[] catsFamily, Plate plate) {
        for (int i = 0; i < catsFamily.length; i++) {
            catsFamily[i].eat(plate);
        }
    }

}
