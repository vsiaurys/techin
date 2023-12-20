public class PaymentTerminal {
    private double money;
    private int affordableMeals;
    private int heartyMeals;

    public PaymentTerminal() {
        money = 1000;
        affordableMeals = 0;
        heartyMeals = 0;
    }

    public double eatAffordably(double payment) {
        if (payment < 2.50) {
            return payment;
        }
        money += 2.50;
        affordableMeals++;

        return payment - 2.50;
    }

    public boolean eatAffordably(PaymentCard card) {
        if (card.balance() < 2.50) {
            return false;
        }
        card.takeMoney(2.50);
        affordableMeals++;

        return true;
    }

    public double eatHeartily(double payment) {
        if (payment < 4.30) {
            return payment;
        }
        money += 4.30;
        heartyMeals++;

        return payment - 4.30;
    }

    public boolean eatHeartily(PaymentCard card) {
        if (card.balance() < 4.30) {
            return false;
        }
        card.takeMoney(4.30);
        heartyMeals++;

        return true;
    }

    public void addMoneyToCard(PaymentCard card, double sum) {
        if (sum > 0.0) {
            card.addMoney(sum);
            money += sum;
        }
    }

    public String toString() {
        return "money: " + money + ", number of sold affordable meals: " + affordableMeals + ", number of sold hearty meals: " + heartyMeals;
    }
}