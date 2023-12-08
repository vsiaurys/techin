
import java.util.Scanner;

public class RepeatingBreakingAndRemembering {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
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