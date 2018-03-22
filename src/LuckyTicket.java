public class LuckyTicket {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 0; i <= 999; i++){
            for (int j = 1; j <= 999; j++) {
                if (i%100/10+i/100+i%10 == j%100/10+j/100+j%10) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
