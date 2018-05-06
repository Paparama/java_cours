package reflection.annotation;

public class UsingUser {
    public static void main(String[] args) {
        User user = new User();
        Class<?> actionClass = DeleteAction.class;
        PermissionRequired permissionRequired = actionClass.getAnnotation(PermissionRequired.class);
        if (permissionRequired != null) {
            if (user != null && user.getPremissionList().contains(permissionRequired.value())) {
                // some code
            }
        }
    }
}
