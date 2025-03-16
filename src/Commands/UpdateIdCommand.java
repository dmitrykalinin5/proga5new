package Commands;

import Collections.CollectionManager;
import Console.Client;

import java.util.Arrays;
import java.util.Deque;

public class UpdateIdCommand implements Command {
    private int id;
    private final CollectionManager collectionManager;
    private final Deque<String> historyDeque;
    // Потом переделай string в int

    public UpdateIdCommand(CollectionManager collectionManager, Deque<String> historyDeque) {
        this.collectionManager = collectionManager;
        this.historyDeque = historyDeque;
    }

    @Override
    public void execute(String[] args) {
        try {
            Client client = new Client(collectionManager, historyDeque);
            id = Integer.parseInt(args[1]);
            System.out.println("Какой элемент вы хотите обновить? (имя, координаты, цена, тип билета");
            System.out.print("дата рождения, рост, вес, локация): ");
            while (true) {
                String input = client.userInput();
                boolean isUpdated = collectionManager.update(id, input);
                if (isUpdated) {
                    break;
                } else {
                    System.out.print("Некорректный ввод, попробуйте еще раз: ");
                }
            }
            System.out.println("Данные обновлены");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Некорректный ввод");
        }
    }

    @Override
    public String description() { return "Обновить айди вроде"; }
}
