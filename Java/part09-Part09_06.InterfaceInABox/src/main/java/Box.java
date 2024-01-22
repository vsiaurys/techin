public class Box {
    double capacity;
    double weight;
    int items;

    public Box(double capacity) {
        this.capacity = capacity;
        weight = 0.0;
        items = 0;
    }

    public void add(Packable item) {
        if (capacity >= weight + item.weight()) {
            weight += item.weight();
            items++;
        }
    }

    public String toString() {
        return "Box: " + items + " items, total weight " + weight + " kg";
    }
}
