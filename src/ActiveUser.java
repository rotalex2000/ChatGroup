public class ActiveUser extends User {

    public ActiveUser(String name) {
        super(name);
    }

    public void sendMessage(String message) {
        this.getChatGroup().newMessage(this, message);
    }
}
