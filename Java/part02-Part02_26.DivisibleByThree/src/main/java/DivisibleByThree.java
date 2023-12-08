
public class DivisibleByThree {

    public static void main(String[] args) {
        divisibleByThreeInRange(4, 28);
    }

    public static void divisibleByThreeInRange(int beginning, int end) {
        for (int i = beginning; i <= end; i++) {
            int reminder = i % 3;
            if (reminder == 0) {
                System.out.println(i);
            }
        }
    }
}