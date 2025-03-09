package Console;

import Collections.CollectionManager;

public class Session {
    private final CollectionManager collectionManager;

    public Session(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void run() {
        Client client = new Client(collectionManager);
        client.userInput();
    }
}
