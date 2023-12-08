
import java.util.Scanner;

public class RepeatingBreakingAndRemembering {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Part 1
//        int number = 0;
//
//        System.out.println("Give numbers:");
//
//        while (number != -1) {
//            number = Integer.valueOf(scanner.nextLine());
//        }
//
//        System.out.println("Thx! Bye!");

        // Part 2
//        int number = 0;
//        int sum = 0;
//
//        System.out.println("Give numbers:");
//
//        while (number != -1) {
//            sum = sum + number;
//            number = Integer.valueOf(scanner.nextLine());
//        }
//
//        System.out.println("Thx! Bye!");
//        System.out.println("Sum: " + sum);

        // Part 3
//        int number = 0;
//        int sum = 0;
//        int numberOfNumbers = 0;
//
//        System.out.println("Give numbers:");
//        number = Integer.valueOf(scanner.nextLine());
//
//        while (number != -1) {
//            sum = sum + number;
//            numberOfNumbers++;
//            number = Integer.valueOf(scanner.nextLine());
//        }
//
//        System.out.println("Thx! Bye!");
//        System.out.println("Sum: " + sum);
//        System.out.println("Numbers: " + numberOfNumbers);

        // Part 4
//        int number = 0;
//        int sum = 0;
//        int numberOfNumbers = 0;
//        double average = 0.0;
//
//        System.out.println("Give numbers:");
//        number = Integer.valueOf(scanner.nextLine());
//
//        while (number != -1) {
//            sum = sum + number;
//            numberOfNumbers++;
//            number = Integer.valueOf(scanner.nextLine());
//        }
//
//        average = (double) sum / numberOfNumbers;
//        System.out.println("Thx! Bye!");
//        System.out.println("Sum: " + sum);
//        System.out.println("Numbers: " + numberOfNumbers);
//        System.out.println("Average:" + average);

//        // Part 5
        int number = 0;
        int sum = 0;
        int numberOfNumbers = 0;
        double average = 0.0;
        int evenNumbers = 0;
        int oddNumbers =  0;

        System.out.println("Give numbers:");

        while (true) {
            number = Integer.valueOf(scanner.nextLine());

            if (number == -1) {
                break;
            }

            if (number % 2 == 0) {
                evenNumbers++;
            } else {
                oddNumbers++;
            }
            sum = sum + number;
            numberOfNumbers++;

        }

        average = (double) sum / numberOfNumbers;
        System.out.println("Thx! Bye!");
        System.out.println("Sum: " + sum);
        System.out.println("Numbers: " + numberOfNumbers);
        System.out.println("Average:" + average);
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
    }
}