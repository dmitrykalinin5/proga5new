package Console;

import java.util.Deque;
import java.util.Scanner;
import Commands.CommandProcessor;
import Collections.CollectionManager;

public class Client {
    private final CollectionManager collectionManager;
    private Deque<String> historyDeque;
    private CommandProcessor commandProcessor;

    public Client(CollectionManager collectionManager, Deque<String> historyDeque, CommandProcessor commandProcessor) {
        this.collectionManager = collectionManager;
        this.historyDeque = historyDeque;
        this.commandProcessor = commandProcessor;
    }

    public void interact() {
        System.out.print("Enter command: ");
        executeCommand();
    }

    public String userInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.trim();
    }

    public void executeCommand() {
        String command = userInput();
        commandProcessor.CommandPut();
        commandProcessor.executeCommand(command);
    }
}
