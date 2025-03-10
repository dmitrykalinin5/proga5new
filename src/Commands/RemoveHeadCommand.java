package Commands;

import Collections.CollectionManager;

public class RemoveHeadCommand implements Command {
    private CollectionManager collectionManager;

    public RemoveHeadCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        boolean result = collectionManager.removeHead();
        if (result) {
            System.out.println("Элемент успешно выведен и удален");
        } else {
            System.out.println("Нечего выводить! Коллекция пуста");
        }
    }

    @Override
    public String description() { return "Displays and removes the first element from collection"; }
}
