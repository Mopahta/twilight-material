package by.mopahta.laba.task2;

public class PointLocation {
    public void testFunction () {
        double[] xValues = new double[20];
        double[] yValues = new double[20];
        for (int i = 0; i < 20; i++) {
            xValues[i] = Math.random() * 10 - 10;
            yValues[i] = Math.random() * 10 - 10;
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(resolvePointLocation(xValues[i],yValues[i]) + " " + xValues[i] + " " + yValues[i]);
        }
    }

    private boolean resolvePointLocation (double xValue, double yValue) {
        if (xValue > -4 && xValue < 4 && yValue > 0 && yValue < 4) return true;
        return xValue > -6 && xValue < 6 && yValue > -3 && yValue < 0;
    }
}
