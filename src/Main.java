import Console.Session;
import Commands.ExitCommand;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Session session = new Session();
            session.run();
        }
    }
}