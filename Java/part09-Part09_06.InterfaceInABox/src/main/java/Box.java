import java.util.ArrayList;

public class Box implements Packable {
    private double capacity;
    private ArrayList<Packable> items;

    public Box(double capacity) {
        this.capacity = capacity;
        items = new ArrayList<Packable>();
    }

    public void add(Packable packable) {
        if (capacity >= weight() + packable.weight()) {
            items.add(packable);
        }
    }

    public double weight() {
        double weight = 0;

        for (Packable item : items) {
            weight += item.weight();
        }

        return weight;
    }

    public String toString() {
        int itemsCount = 0;

        for (Packable item : items) {
            itemsCount++;
        }

        return "Box: " + itemsCount + " items, total weight " + weight() + " kg";
    }
}
