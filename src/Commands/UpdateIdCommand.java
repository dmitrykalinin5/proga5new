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
        Client client = new Client(collectionManager, historyDeque);
        id = Integer.parseInt(args[1]);
        System.out.println("Какой элемент вы хотите обновить? (имя, координаты, цена, тип билета");
        System.out.print("дата рождения, рост, вес, локация): ");
        String input = client.userInput();
//        collectionManager.update(id, input);
//        System.out.println("Апдейдим айди " + Arrays.toString(args));
    }

    @Override
    public String description() { return "Обновить айди вроде"; }
}
