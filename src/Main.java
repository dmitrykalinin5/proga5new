import Collections.CollectionManager;
import Commands.CommandProcessor;
import Console.Session;
import Collections.CollectionManager;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        collectionManager.loadFromFile();
        Deque<String> historyDeque = new ArrayDeque<>();
        CommandProcessor commandProcessor = new CommandProcessor(collectionManager, historyDeque);
        collectionManager.setCommandProcessor(commandProcessor);
        while (true) {
            Session session = new Session(collectionManager, historyDeque, commandProcessor);
            session.run();
        }
    }
}