package Commands;

import Collections.CollectionManager;

/**
 * Команда для удаления первого элемента из коллекции.
 * Этот класс реализует команду, которая удаляет первый элемент из коллекции.
 */
public class RemoveFirstCommand implements Command {
    private CollectionManager collectionManager;

    /**
     * Конструктор для создания объекта RemoveFirstCommand.
     *
     * @param collectionManager Объект, управляющий коллекцией
     */
    public RemoveFirstCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду удаления первого элемента из коллекции.
     * Если коллекция не пуста, первый элемент будет удален и будет выведено сообщение об успешном удалении.
     * Если коллекция пуста, будет выведено сообщение, что нечего удалять.
     *
     * @param args Аргументы команды (не используются в данном случае)
     */
    @Override
    public void execute(String[] args) {
        boolean result = collectionManager.removeFirst();
        if (result) {
            System.out.println("Элемент успешно удален");
        } else {
            System.out.println("Нечего удалять! Коллекция пуста");
        }
    }

    /**
     * Описание команды.
     *
     * @return Описание команды, которая удаляет первый элемент из коллекции.
     */
    @Override
    public String description() {
        return "Removes the first element from collection";
    }
}
