
public class Main {

    public static void main(String[] args) {
        TripleTacoBox ttb = new TripleTacoBox();

        int tacos = ttb.tacosRemaining();

        System.out.println("Triple = " + tacos);

        CustomTacoBox ctb = new CustomTacoBox(4);
        tacos = ctb.tacosRemaining();
        System.out.println("Custom before eating = " + tacos);

        ctb.eat();
        tacos = ctb.tacosRemaining();
        System.out.println("Custom after eating = " + tacos);
    }
}
