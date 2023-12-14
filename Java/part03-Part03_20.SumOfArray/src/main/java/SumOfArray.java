
public class SumOfArray {

    public static int sumOfNumbersInArray(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 1, 3, 4, 2};

        System.out.println(sumOfNumbersInArray(numbers));
    }
}