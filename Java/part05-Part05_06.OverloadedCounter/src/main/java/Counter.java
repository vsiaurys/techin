public class Counter {
    private int counter;

    public Counter() {
        this(0);
    }

    public Counter(int startValue) {
        counter = startValue;
    }

    public int value() {
        return counter;
    }

    public void increase() {
        this.increase(1);
    }

    public void increase(int increaseBy) {
        if (increaseBy > 0) {
            counter += increaseBy;
        }
    }

    public void decrease() {
        this.decrease(1);
    }

    public void decrease(int decreaseBy) {
        if (decreaseBy > 0) {
            counter -= decreaseBy;
        }
    }
}