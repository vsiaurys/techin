import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<TelevisionProgram> tvPrograms = new ArrayList<>();

        while (true) {
            System.out.print("Name: ");
            String name = scan.nextLine();

            if (name.isEmpty()) {
                break;
            }

            System.out.print("Duration: ");
            int duration = Integer.valueOf(scan.nextLine());

            tvPrograms.add(new TelevisionProgram(name, duration));
        }

        System.out.println();
        System.out.print("Program's maximum duration? ");
        int maxDuration = Integer.valueOf(scan.nextLine());

        for (TelevisionProgram tvProgram : tvPrograms) {
            if (tvProgram.getDuration() <= maxDuration) {
                System.out.println(tvProgram);
            }
        }
    }
}