package lesson5.operations;

public class Divide extends Operation{

    protected double execute(double a, double b){
        if (b != 0) {
            return a / b;
        }
        else {
            System.out.println("Деление на ноль");
            return 0;
        }
    }

    protected Divide() {
    }
}
