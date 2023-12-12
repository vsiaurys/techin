
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfAList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == -1) {
                break;
            }
            numbers.add(input);
        }

        int sumOfTheList = 0;

        for (int number : numbers) {
            sumOfTheList = sumOfTheList + number;
        }
        System.out.println("Average: " + (double) sumOfTheList / numbers.size());
    }
}