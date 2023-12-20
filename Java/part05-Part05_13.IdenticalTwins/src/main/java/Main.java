
public class Main {

    public static void main(String[] args) {
        SimpleDate date = new SimpleDate(24, 3, 2017);
        SimpleDate date2 = new SimpleDate(24, 3, 2017);

        Person leo = new Person("Leo", date, 65, 8);
        Person lily = new Person("Lily", date2, 65, 8);

        if (leo.equals(lily)) {
            System.out.println(1);
        }

        Person leoWithDifferentWeight = new Person("Leo", date, 62, 10);

        if (leo.equals(leoWithDifferentWeight)) {
            System.out.println(2);
        }

        Person leoWithTheSameWeight = new Person("Leo", date, 65, 8);

        if (leo.equals(leoWithTheSameWeight)) {
            System.out.println(3);
        }
    }
}
