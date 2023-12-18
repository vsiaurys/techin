import java.util.ArrayList;
import java.util.Scanner;

public class Items {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> names = new ArrayList<>();

        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            if (name.equals("")) {
                break;
            }

            names.add(new Item(name));
        }

        for (Item i : names) {
            System.out.println(i);
        }
    }
}
