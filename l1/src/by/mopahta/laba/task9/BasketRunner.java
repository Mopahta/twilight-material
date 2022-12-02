package by.mopahta.laba.task9;

import java.util.List;

public class BasketRunner {
    public static void main(String[] args) {
        Basket basket = new Basket(50);
        List<Ball> balls = List.of(
                new Ball(2.5,"blue"),
                new Ball(4,"red"),
                new Ball(3,"white"),
                new Ball(3,"BLUE"),
                new Ball(2.5,"orange"));
        basket.setBalls(balls);
        getWeightAndQuantity(basket);
    }

    private static void getWeightAndQuantity(Basket basket) {
        double weight = 0;
        int quantity = 0;
        for (var ball : basket.getBalls()) {
            weight += ball.getWeight();
            if (ball.getColor().equalsIgnoreCase("blue")) {
                quantity++;
            }
        }
        System.out.println("weight = " + weight + "\nblue balls quantity = " + quantity);
    }
}
