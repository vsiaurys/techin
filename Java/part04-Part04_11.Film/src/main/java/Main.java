import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Film chipmunks = new Film("Alvin and the Chipmunks: The Squeakquel", 12);

        Scanner reader = new Scanner(System.in);

        System.out.println("How old are you?");
        int age = Integer.valueOf(reader.nextLine());

        System.out.println();
        if (age >= chipmunks.ageRating()) {
            System.out.println("You may watch the film " + chipmunks.name());
        } else {
            System.out.println("You may not watch the film " + chipmunks.name());
        }
    }
}