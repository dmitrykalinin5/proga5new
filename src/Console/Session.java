package Console;

import Collections.CollectionManager;

import java.util.Deque;

public class Session {
    private final CollectionManager collectionManager;
    private Deque<String> historyDeque;

    public Session(CollectionManager collectionManager, Deque<String> historyDeque) {
        this.collectionManager = collectionManager;
        this.historyDeque = historyDeque;
    }

    public void run() {
        Client client = new Client(collectionManager, historyDeque);
        client.userInput();
    }
}
