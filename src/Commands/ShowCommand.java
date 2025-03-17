package Commands;

import Collections.CollectionManager;

/**
 * Команда для отображения всех элементов коллекции.
 * Этот класс реализует команду, которая выводит все элементы текущей коллекции.
 */
public class ShowCommand implements Command {
    private final CollectionManager collectionManager;

    /**
     * Конструктор для создания объекта ShowCommand.
     *
     * @param collectionManager Объект, управляющий коллекцией.
     */
    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду отображения всех элементов коллекции.
     * Выводит элементы коллекции, вызывая метод getAllElements из CollectionManager.
     *
     * @param args Аргументы команды (не используются в данном случае).
     */
    @Override
    public void execute(String[] args) {
        System.out.print(collectionManager.getAllElements());
    }

    /**
     * Описание команды.
     *
     * @return Описание команды, которая отображает все элементы коллекции.
     */
    @Override
    public String description() {
        return "Displays all elements from collection";
    }
}
