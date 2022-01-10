public class UserFactory {

    public UserFactory() {
    }

    public User getUser(UserType userType, String name) {
        switch (userType) {
            case OBSERVER:
                return new Observer(name);
            case ACTIVE_USER:
                return new ActiveUser(name);
            default:
                break;
        }
        return new Observer(name);
    }
}
