package classWorkLesson25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bank {
    private Map<User, Account> users = new HashMap<>();
    static List<Account> lockedAcc = new ArrayList<>();

    public boolean transferMoney(Account src, Account dst, int amount) {
                if (src.getAmount() < amount) {
                    return false;
                }
                if (src.equals(dst)) {
                    return false;
                }
                int startSrc = src.getAmount();
                int startDst = dst.getAmount();
                try {
                    src.setAmount(src.getAmount() - amount);
                    dst.setAmount(dst.getAmount() + amount);
                    return true;
                } catch (Exception e) {
                    src.setAmount(startSrc);
                    dst.setAmount(startDst);
                    return false;
                }
            }


    private void addUserAndAcc(User u, Account acc){
        this.users.put(u, acc);
    }

    public Account getUserAcc(User u){
        return this.users.get(u);
    }

    private static class TransactionThread extends Thread {
        private Account src ;
        private Account dst;
        private int amount;
        private Bank bank;

        public TransactionThread(Account src, Account dst, int amount, Bank bank) {
            this.src = src;
            this.dst = dst;
            this.amount = amount;
            this.bank = bank;
        }

        @Override
        public void run() {
            synchronized ((Integer) this.src.getAccountId()) {
                Bank.lockedAcc.add(src);
                while (lockedAcc.contains(dst)) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        lockedAcc.remove(src);
                    }
                } synchronized ((Integer) this.dst.getAccountId()) {
                    System.out.println(bank.transferMoney(this.src, this.dst, this.amount) + Thread.currentThread().getName());
                    lockedAcc.remove(src);
                }
            }
        }
    }
        public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        User user1 = new User("kokoko1");
        User user2 = new User("kokoko2");
        User user3 = new User("kokoko3");
        User user4 = new User("kokoko4");
        bank.addUserAndAcc(user1, new Account(100, user1));
        bank.addUserAndAcc(user2, new Account(200, user2));
        bank.addUserAndAcc(user3, new Account(300, user3));
        bank.addUserAndAcc(user4, new Account(400, user4));
        List<Thread> workers = new ArrayList<>();
            for (int i = 0; i <  100 ; i++) {
                Thread t = new TransactionThread(bank.getUserAcc(user1), bank.getUserAcc(user2), 1, bank);
                Thread t2 = new TransactionThread(bank.getUserAcc(user3), bank.getUserAcc(user1), 1, bank);
                Thread t3 = new TransactionThread(bank.getUserAcc(user2), bank.getUserAcc(user1), 1, bank);
                workers.add(t);
                workers.add(t2);
                workers.add(t3);
                t.start();
                t2.start();
                t3.start();

            }
            for (Thread t: workers
                 ) {
                t.join();

            }

            System.out.println(bank.users.get(user1).getAmount());
            System.out.println(bank.users.get(user2).getAmount());
            System.out.println(bank.users.get(user3).getAmount());

    }

}
