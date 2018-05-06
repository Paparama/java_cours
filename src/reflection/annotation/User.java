package reflection.annotation;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static enum Premission {
        USER, ADMIN
    }

    private List<Premission> premissionList;
    public List<Premission> getPremissionList() {
        return new ArrayList<Premission>(premissionList);
    }
}
