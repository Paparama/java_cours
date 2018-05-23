package classWorkLesson25;

public class User {
    private static int id_cnt;
    private String email;
    private int id;

    public User(String mail){
        int id = User.id_cnt;
        User.id_cnt++;
        this.email=mail;
    }

    public int getUserId(){
        return this.id;
    }

    public String getUserEmail(){
        return this.email;
    }

}
