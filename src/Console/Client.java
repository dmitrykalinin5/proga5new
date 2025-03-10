package Console;

import java.util.Deque;
import java.util.Scanner;
import Commands.CommandProcessor;
import Collections.CollectionManager;

public class Client {
    private final CollectionManager collectionManager;
    private Deque<String> historyDeque;

    public Client(CollectionManager collectionManager, Deque<String> historyDeque) {
        this.collectionManager = collectionManager;
        this.historyDeque = historyDeque;
    }

    public void userInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter command: ");
        String command = scanner.nextLine();
        CommandProcessor commandProcessor = new CommandProcessor(collectionManager, historyDeque);
        commandProcessor.CommandPut();
        /* Обращаемся к commandprocessor, берем метод put, передаем ему команду,
        которую ввел пользователь */
        commandProcessor.executeCommand(command);
    }
}
