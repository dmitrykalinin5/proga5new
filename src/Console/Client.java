package Console;

import java.util.Scanner;
import Commands.CommandProcessor;

public class Client {

    public void userInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter command: ");
        String command = scanner.nextLine();
        CommandProcessor commandProcessor = new CommandProcessor();
        commandProcessor.CommandPut();
        /* Обращаемся к commandprocessor, берем метод put, передаем ему команду,
        которую ввел пользователь */
        commandProcessor.executeCommand(command);
    }
}
