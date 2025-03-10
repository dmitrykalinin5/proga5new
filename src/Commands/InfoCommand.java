package Commands;

import Collections.CollectionManager;

public class InfoCommand implements Command {
    private final CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        System.out.println(collectionManager.collectionInfo());
    }

    @Override
    public String description() { return "Displays information about the collection"; }
}
