package lesson5.operations;

public class Plus extends Operation{
    @Override
    protected double execute(double a, double b){
        return a + b;
    }

    protected Plus(double a, double b) {
    }
}
