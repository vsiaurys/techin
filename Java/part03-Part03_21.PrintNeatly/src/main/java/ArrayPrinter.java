
public class ArrayPrinter {

    public static void main(String[] args) {
        int[] numbers = {5, 1, 3, 4, 2};

        printNeatly(numbers);
    }

    public static void printNeatly(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println(numbers[numbers.length - 1]);
    }
}