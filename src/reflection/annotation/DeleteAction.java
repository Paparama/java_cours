package reflection.annotation;

@PermissionRequired(User.Premission.USER)
public class DeleteAction {
    public void delete(User user) {}
}
