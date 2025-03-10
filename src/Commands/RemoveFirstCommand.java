package Commands;

import Collections.CollectionManager;

public class RemoveFirstCommand implements Command {
    private CollectionManager collectionManager;

    public RemoveFirstCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        boolean result = collectionManager.removeFirst();
        if (result) {
            System.out.println("Элемент успешно удален");
        } else {
            System.out.println("Нечего удалять! Коллекция пуста");
        }
    }

    @Override
    public String description() { return "Removes the first element from collection"; }
}
