package by.mopahta.task01.entity;
import java.util.Comparator;
public class AppliancePriceComparator implements Comparator<Appliance> {
    @Override
    public int compare(Appliance o1, Appliance o2) {

        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
