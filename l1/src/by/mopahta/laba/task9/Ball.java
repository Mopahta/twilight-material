package by.mopahta.laba.task9;

public class Ball {

    private double weight;
    private String color;

    public double getWeight () {
        return weight;
    }

    public void setWeight (double weight) {
        this.weight = weight;
    }

    public String getColor () {
        return color;
    }

    public void setColor (String color) {
        this.color = color;
    }

    public Ball (double weight, String color) {
        this.weight = weight;
        this.color = color;
    }
}
