package by.mopahta.task01.entity;
import java.util.ArrayList;
public class ApplianceFactory {
    public Appliance createInstance(String name, ArrayList<String> params){
        return switch (name) {
            case "laptop" -> Laptop.createInstance(params);
            case "oven" -> Oven.createInstance(params);
            case "refrigerator" -> Refrigerator.createInstance(params);
            case "speakers" -> Speakers.createInstance(params);
            case "tabletpc" -> TabletPC.createInstance(params);
            case "vacuumcleaner" -> VacuumCleaner.createInstance(params);
            default -> null;
        };
    }
}
