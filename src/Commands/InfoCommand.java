package Commands;

import Collections.CollectionManager;

/**
 * Команда для вывода информации о коллекции.
 * Этот класс реализует команду, которая отображает информацию о коллекции, используя CollectionManager.
 */
public class InfoCommand implements Command {
    private final CollectionManager collectionManager;

    /**
     * Конструктор для создания объекта InfoCommand.
     *
     * @param collectionManager Объект, управляющий коллекцией
     */
    public InfoCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду вывода информации о коллекции.
     * Этот метод вызывает метод collectionInfo() из CollectionManager и выводит информацию на экран.
     *
     * @param args Аргументы команды (не используются в данном случае)
     */
    @Override
    public void execute(String[] args) {
        System.out.println(collectionManager.collectionInfo());
    }

    /**
     * Описание команды.
     *
     * @return Описание команды, которая выводит информацию о коллекции
     */
    @Override
    public String description() {
        return "Displays information about the collection";
    }
}
