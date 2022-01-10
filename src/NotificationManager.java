public final class NotificationManager {

    private static NotificationManager INSTANCE;

    private NotificationManager() {
    }

    public static NotificationManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new NotificationManager();
        }

        return INSTANCE;
    }

    public void notify(User user, String message) {
        System.out.println("==========");
        System.out.println("Notification for " + user.getName() + ":");
        System.out.println(message);
    }
}