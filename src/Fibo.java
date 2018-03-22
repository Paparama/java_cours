public class Fibo {
    public static void main(String[] args) {
        int a = 1, b = 1;
        System.out.println(a);
        System.out.println(b);
        for (int i=1; i <= 9; i++) {
            System.out.println(a+b);
            a = i%2 == 0 ? a:a+b;
            b = i%2 == 1 ? b:b+a;
        }
    }
}
