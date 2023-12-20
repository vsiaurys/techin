
public class HealthStation {

    private int counter;

    public int weigh(Person person) {
        if (person != null) {
            counter++;
            return person.getWeight();
        }

        return -1;
    }

    public void feed(Person person) {
        person.setWeight(person.getWeight() + 1);
    }

    public int weighings() {
        return counter;
    }
}