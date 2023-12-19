import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Title: ");
            String title = scan.nextLine();

            if (title.isEmpty()) {
                break;
            }
            System.out.print("Pages: ");
            int pages = Integer.valueOf(scan.nextLine());

            System.out.print("Publication year: ");
            int year = Integer.valueOf(scan.nextLine());
            books.add(new Book(title, pages, year));
        }

        System.out.print("What information will be printed? ");
        String whatPrinted = scan.nextLine();
        if (whatPrinted.equals("everything")) {
            for (Book book : books) {
                System.out.println(book);
            }
        }
        if (whatPrinted.equals("name")) {
            for (Book book : books) {
                System.out.println(book.getName());
            }
        }
    }
}