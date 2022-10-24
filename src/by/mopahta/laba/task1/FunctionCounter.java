package by.mopahta.laba.task1;

public class FunctionCounter {

    public void testFunction () {
        double[] xValues = new double[20];
        double[] yValues = new double[20];
        for (int i = 0; i < 20; i++) {
            xValues[i] = Math.random() * 50 - 50;
            yValues[i] = Math.random() * 50 - 50;
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(countFunction(xValues[i],yValues[i]));
        }
    }
    private Double countFunction (double x, double y) {
        return ((1 + Math.sin(x + y) * Math.sin(x + y)) / (2 + Math.abs(x - 2 * x / (1 + x * x * y * y)))) + x;
    }
}
