package lesson5.operations;

public class Accumulate {
    private double a;
    private Operation o;

    private Accumulate(Operation o, double a) {
        this.a = a;
        this.o = o;
    }

    private void accum(double b) {
        this.a = this.o.execute(this.a, b);
    }

    private double getValue() {
        return this.a;
    }

    public static void main(String[] args) {
        Accumulate ac = new Accumulate(new Divide(), 12.5);
        ac.accum( 6);
        System.out.println(ac.getValue());
    }
}
