import java.util.Scanner;
import java.util.ArrayList;

public class PersonalInformationCollection {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<PersonalInformation> persons = new ArrayList<>();

        while (true) {
            System.out.print("First name: ");
            String firstName = new String(scan.nextLine());

            if (firstName.isEmpty()) {
                break;
            }
            System.out.print("Last name: ");
            String lastName = new String(scan.nextLine());

            System.out.print("Identification number: ");
            String idNumber = new String(scan.nextLine());

            persons.add(new PersonalInformation(firstName, lastName, idNumber));
        }

        System.out.println();
        for (PersonalInformation person : persons) {
            System.out.println(person.getFirstName() + " " + person.getLastName());
        }
    }
}
