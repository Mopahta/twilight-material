package by.mopahta.laba.task9;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Ball> balls;
    private double size;

    public Basket (double size) {
        balls = new ArrayList<>();
        this.size = size;
    }

    public List<Ball> getBalls () {
        return balls;
    }

    public void setBalls (List<Ball> balls) {
        this.balls = balls;
    }

    public double getSize () {
        return size;
    }

    public void setSize (double size) {
        this.size = size;
    }

    public void addBall (Ball ball) {
        balls.add(ball);
    }
}
