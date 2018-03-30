package lesson5.operations;

public class Minus extends Operation{
    @Override
    protected double execute(double a, double b){
        return a - b;
    }

    protected Minus(double a, double b) {
    }
}
