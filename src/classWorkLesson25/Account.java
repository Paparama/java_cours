package classWorkLesson25;

public class Account {
    private int amount;
    private static int id_cnt;
    private int userId;
    private int id;

    public Account(int amount, User user){
        this.id = Account.id_cnt;
        Account.id_cnt++;
        this.amount = amount;
        this.userId = user.getUserId();
    }

    public int getAmount(){
        return this.amount;
    }

    public int getUserId(){
        return this.userId;
    }

    public int getAccountId(){
        return this.id;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }
}
