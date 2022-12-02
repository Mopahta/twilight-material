package by.mopahta.task01.entity;

import java.util.ArrayList;

public class Refrigerator extends Appliance{
    //POWER_CONSUMPTION, WEIGHT, FREEZER_CAPACITY, OVERALL_CAPACITY, HEIGHT, WIDTH
    private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private int overallCapacity;
    private int height;
    private int width;

    public Refrigerator(int powerConsumption, int weight, int freezerCapacity, int overallCapacity, int height, int width, int price) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.width = width;
        this.setPrice(price);
    }

    public static Refrigerator createInstance(ArrayList<String> params) {
        return new Refrigerator(
                Integer.parseInt(params.get(0)),
                Integer.parseInt(params.get(1)),
                Integer.parseInt(params.get(2)),
                Integer.parseInt(params.get(3)),
                Integer.parseInt(params.get(4)),
                Integer.parseInt(params.get(5)),
                Integer.parseInt(params.get(6))
        );
    }

    public Object getFieldByName(String name){
        return switch (name) {
            case "POWER_CONSUMPTION" -> powerConsumption;
            case "WEIGHT" -> weight;
            case "FREEZER_CAPACITY" -> freezerCapacity;
            case "OVERALL_CAPACITY" -> overallCapacity;
            case "HEIGHT" -> height;
            case "WIDTH" -> width;
            case "PRICE" -> getPrice();
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", freezerCapacity=" + freezerCapacity +
                ", overallCapacity=" + overallCapacity +
                ", height=" + height +
                ", width=" + width +
                ", price=" + getPrice() +
                '}';
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public int getOverallCapacity() {
        return overallCapacity;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public void setOverallCapacity(int overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    // you may add your own code here
}
