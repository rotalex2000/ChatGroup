import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {
    public static void main(String[] args) {
        ChatGroup chatGroup = new ChatGroup();

        chatGroup.addUser("Alex", UserType.ACTIVE_USER);
        chatGroup.addUser("Mihai", UserType.ACTIVE_USER);

        ActiveUser alex = (ActiveUser)chatGroup.getUser("Alex");
        ActiveUser mihai = (ActiveUser)chatGroup.getUser("Mihai");

        alex.sendMessage("Ceau Mihai!");
        mihai.sendMessage("Ceau Alex! Ce faci?");
        alex.sendMessage("Uite bine. Vezi că ies din grup.");

        alex.leaveChatGroup();

        mihai.sendMessage("Ce truda mea? Mesajul ăsta cine îl vede? :(");
    }
}