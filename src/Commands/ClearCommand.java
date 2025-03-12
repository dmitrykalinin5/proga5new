package Commands;

import Collections.CollectionManager;

public class ClearCommand implements Command {
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.clearAllElements();
        System.out.println("Коллекция очищена");
    }

    @Override
    public String description() { return "Clears collection"; }
}
