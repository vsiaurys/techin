

import java.util.ArrayList;

public class Hold {

    private ArrayList<Suitcase> suitcases;
    private int maximumWeight;

    public Hold(int maximumWeight) {
        this.maximumWeight = maximumWeight;
        this.suitcases = new ArrayList<>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if (this.totalWeight() + suitcase.totalWeight() > maximumWeight) {
            return;
        }

        this.suitcases.add(suitcase);
    }

    public int totalWeight() {
        int sum = this.suitcases.stream()
                .map(item -> item.totalWeight())
                .reduce(0, (total, weight) -> total + weight);

        return sum;
    }

    public void printItems() {
        this.suitcases.stream()
                .map(s -> s.getItems())
                .forEach(item -> System.out.println(item));
    }

    @Override
    public String toString() {
        if (this.suitcases.isEmpty()) {
            return "no suitcases (0 kg)";
        }

        if (this.suitcases.size() == 1) {
            return "1 suitcase (" + this.totalWeight() + " kg)";
        }

        return this.suitcases.size() + " suitcases (" + this.totalWeight() + " kg)";
    }
}