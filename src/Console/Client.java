package Console;

import java.util.Scanner;
import Commands.CommandProcessor;
import Collections.CollectionManager;

public class Client {
    private final CollectionManager collectionManager;

    public Client(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void userInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter command: ");
        String command = scanner.nextLine();
        CommandProcessor commandProcessor = new CommandProcessor(collectionManager);
        commandProcessor.CommandPut();
        /* Обращаемся к commandprocessor, берем метод put, передаем ему команду,
        которую ввел пользователь */
        commandProcessor.executeCommand(command);
    }
}
