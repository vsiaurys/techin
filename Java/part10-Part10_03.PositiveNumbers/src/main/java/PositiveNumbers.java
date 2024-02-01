import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(-4);
        list.add(-2);
        list.add(6);
        list.add(-3);
        list.add(7);
        list.add(-4);
        list.add(2);
        list.add(-6);

        System.out.println(positive(list));
    }

    public static List<Integer> positive(List<Integer> numbers) {
        ArrayList<Integer> list = numbers.stream()
                .filter(number -> number > 0)
                .collect(Collectors.toCollection(ArrayList::new));

        return list;
    }
}