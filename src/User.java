public abstract class User {
    private final String name;
    private ChatGroup chatGroup;

    public User(String name) {
        this.name = name;
    }

    public ChatGroup getChatGroup() {
        return chatGroup;
    }

    public void setChatGroup(ChatGroup chatGroup) {
        this.chatGroup = chatGroup;
    }

    public String getName() {
        return name;
    }

    public void notifyNewUser(User user) {
        NotificationManager notificationManager = NotificationManager.getInstance();
        notificationManager.notify(this, user.getName() + " joined the chat.");
    }

    public void notifyUserLeft(User user) {
        NotificationManager notificationManager = NotificationManager.getInstance();
        notificationManager.notify(this, user.getName() + " left the chat.");
    }

    public void notifyNewMessage(User user, String message) {
        NotificationManager notificationManager = NotificationManager.getInstance();
        notificationManager.notify(this, user.getName() + ": \"" + message + "\"");
    }

    public void leaveChatGroup() {
        this.chatGroup.userLeft(this);
    }
}
