package Console;

import Collections.CollectionManager;
import Commands.CommandProcessor;

import java.util.Deque;

public class Session {
    private final CollectionManager collectionManager;
    private Deque<String> historyDeque;
    private CommandProcessor commandProcessor;

    public Session(CollectionManager collectionManager, Deque<String> historyDeque, CommandProcessor commandProcessor) {
        this.collectionManager = collectionManager;
        this.historyDeque = historyDeque;
        this.commandProcessor = commandProcessor;
    }

    public void run() {
        Client client = new Client(collectionManager, historyDeque, commandProcessor);
        client.interact();
    }
}
