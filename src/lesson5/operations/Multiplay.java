package lesson5.operations;

public class Multiplay extends Operation{
    @Override
    protected double execute(double a, double b){
        return a * b;
    }

    protected Multiplay(double a, double b) {
    }
}
