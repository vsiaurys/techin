
public class MainProgram {

    public static void main(String[] args) {
        Counter count = new Counter(5);

        System.out.println(count.value());

        count.increase();

        System.out.println(count.value());

        count.increase(34);

        System.out.println(count.value());

        count.decrease(10);

        System.out.println(count.value());
    }
}