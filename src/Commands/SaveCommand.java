package Commands;

import Collections.CollectionManager;

public class SaveCommand implements Command{
    private final CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Сохранение...");
        collectionManager.saveToFile();
    }

    @Override
    public String description() { return "Save the collection to a file"; }
}
