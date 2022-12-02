package by.mopahta.laba.task3;

public class TanCounter {
    public void testFunction () {
        double h = 0.3;
        double startX = -10;
        double endX = 10;
        System.out.printf("|    x       |      v     |%n");
        while (startX < endX){
            System.out.printf("| %10.2f | %10.7f |%n",startX, countFunction(startX));
            startX += h;
        }
        System.out.printf("| %10.2f | %10.7f |",endX, countFunction(endX));
    }

    private double countFunction (double startX) {
        return Math.tan(startX);
    }
}
