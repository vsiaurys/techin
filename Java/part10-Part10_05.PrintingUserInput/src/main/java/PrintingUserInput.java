import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();

        while (true) {
            String word = scanner.nextLine();
            if (word.equals("")) {
                break;
            }
            inputs.add(word);
        }
        inputs.stream()
                .forEach(word -> System.out.println(word));
    }
}