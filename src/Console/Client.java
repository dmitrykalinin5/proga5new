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

    public String userInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter command: ");
        String input = scanner.nextLine();
        return input.trim();
    }

    public void executeCommand() {
        String command = userInput();
        CommandProcessor commandProcessor = new CommandProcessor(collectionManager, historyDeque);
        commandProcessor.CommandPut();
        commandProcessor.executeCommand(command);
    }
}
