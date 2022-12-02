package by.mopahta.task01.entity;

import java.util.ArrayList;

public class Speakers extends Appliance{
    //POWER_CONSUMPTION, NUMBER_OF_SPEAKERS, FREQUENCY_RANGE, CORD_LENGTH
    private int powerConsumption;
    private int numberOfSpeakers;
    private int frequencyRange;
    private int cordLength;

    public Speakers(int powerConsumption, int numberOfSpeakers, int frequencyRange, int cordLength, int price) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
        this.setPrice(price);
    }

    public static ArrayList<Speakers> createInstances(ArrayList<ArrayList<String>> params) {
        ArrayList<Speakers> appliances = new ArrayList<>();
        for (ArrayList<String> currParams : params) {
            appliances.add(new Speakers(
                    Integer.parseInt(currParams.get(0)),
                    Integer.parseInt(currParams.get(1)),
                    Integer.parseInt(currParams.get(2)),
                    Integer.parseInt(currParams.get(3)),
                    Integer.parseInt(currParams.get(4))
            ));
        }
        return appliances;
    }

    public static Speakers createInstance(ArrayList<String> params) {
        return new Speakers(
                Integer.parseInt(params.get(0)),
                Integer.parseInt(params.get(1)),
                Integer.parseInt(params.get(2)),
                Integer.parseInt(params.get(3)),
                Integer.parseInt(params.get(4))
        );
    }

    public Object getFieldByName(String name){
        return switch (name) {
            case "POWER_CONSUMPTION" -> powerConsumption;
            case "NUMBER_OF_SPEAKERS" -> numberOfSpeakers;
            case "FREQUENCY_RANGE" -> frequencyRange;
            case "CORD_LENGTH" -> cordLength;
            case "PRICE" -> getPrice();
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRange=" + frequencyRange +
                ", cordLength=" + cordLength +
                ", price=" + getPrice() +
                '}';
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public int getFrequencyRange() {
        return frequencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public void setFrequencyRange(int frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    // you may add your own code here
}
