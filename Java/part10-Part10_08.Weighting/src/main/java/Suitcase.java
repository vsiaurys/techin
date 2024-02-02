
import java.util.ArrayList;

public class Suitcase {

    private int maximumWeight;
    private ArrayList<Item> items;

    public Suitcase(int maximumWeight) {
        this.items = new ArrayList<>();
        this.maximumWeight = maximumWeight;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item Item) {
        if (this.totalWeight() + Item.getWeight() > this.maximumWeight) {
            return;
        }

        this.items.add(Item);
    }

    public int totalWeight() {
        int sum = this.items.stream()
                .map(item -> item.getWeight())
                .reduce(0, (total, weight) -> total + weight);

        return sum;
    }

    public void printItems() {
        this.items.stream()
                .forEach(System.out::println);

    }

    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }
        // We will get to know this syntax a little later in the course
        return this.items.stream()
                .max((t1, t2) -> t1.getWeight() - t2.getWeight())
                .get();
    }

    @Override
    public String toString() {
        if (this.items.isEmpty()) {
            return "no items (0 kg)";
        }

        if (this.items.size() == 1) {
            return "1 item (" + this.totalWeight() + " kg)";
        }

        return this.items.size() + " items (" + this.totalWeight() + " kg)";
    }
}
