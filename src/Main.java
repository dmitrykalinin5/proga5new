import Collections.CollectionManager;
import Console.Session;
import Collections.CollectionManager;

public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        collectionManager.loadFromFile();
        
        while (true) {
            Session session = new Session(collectionManager);
            session.run();
        }
    }
}