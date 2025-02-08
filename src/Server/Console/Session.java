package Server.Console;
import Client.Client;

public class Session {

    public void run() {
        Client client = new Client();
        client.userInput();
    }
}
