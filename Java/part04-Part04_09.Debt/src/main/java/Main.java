
public class Main {

    public static void main(String[] args) {
        Debt mortgage = new Debt(120000, 2.2);

        mortgage.printBalance();

        mortgage.waitOneYear();
        mortgage.printBalance();

        for (int i = 0; i < 10; i++) {
            mortgage.waitOneYear();
            mortgage.printBalance();
        }
    }
}