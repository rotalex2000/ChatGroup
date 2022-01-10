import java.util.ArrayList;
import java.util.Objects;

public class ChatGroup {

    private ArrayList<User> users = new ArrayList<>();

    public ChatGroup() {
    }

    public void addUser(String name, UserType userType) {
        if (users.size() != 10) {
            UserFactory userFactory = new UserFactory();
            if (userType == UserType.OBSERVER) {
                int observersCount = 0;
                for (User user : users) {
                    if (user instanceof Observer) {
                        observersCount++;
                    }
                }
                if (observersCount == 2) {
                    System.out.println("Maximum number of observers (2) reached.");
                    return;
                }
            }
            User newUser = userFactory.getUser(userType, name);
            newUser.setChatGroup(this);
            users.add(newUser);
            notifyNewUser(newUser);
        }
    }

    public void userLeft(User user) {
        users.remove(user);
        notifyUserLeft(user);
    }

    public void newMessage(User user, String message) {
        notifyNewMessage(user, message);
    }

    private void notifyNewUser(User newUser) {
        for (User user: users) {
            if (user != newUser) {
                user.notifyNewUser(newUser);
            }
        }
    }

    private void notifyUserLeft(User formerUser) {
        for (User user: users) {
            if (user != formerUser) {
                user.notifyUserLeft(formerUser);
            }
        }
    }

    private void notifyNewMessage(User sender, String message) {
        for (User user: users) {
            if (user != sender) {
                user.notifyNewMessage(sender, message);
            }
        }
    }

    public User getUser(String name) {
        return this.users.stream().filter(user -> Objects.equals(user.getName(), name)).findFirst().orElse(null);
    }
}
