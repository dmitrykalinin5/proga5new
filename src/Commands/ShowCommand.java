package Commands;

import Collections.CollectionManager;

public class ShowCommand implements Command {
    private final CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        System.out.print(collectionManager.getAllElements());
    }

    @Override
    public String description() { return "Displays all elements from collection"; }
}
