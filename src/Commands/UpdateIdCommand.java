package Commands;

import Collections.CollectionManager;
import Console.Client;

import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class UpdateIdCommand implements Command {
    private int id;
    private final CollectionManager collectionManager;
    private final Deque<String> historyDeque;
    private CommandProcessor commandProcessor;
    // Потом переделай string в int

    public UpdateIdCommand(CollectionManager collectionManager, Deque<String> historyDeque, CommandProcessor commandProcessor) {
        this.collectionManager = collectionManager;
        this.historyDeque = historyDeque;
        this.commandProcessor = commandProcessor;
    }

    @Override
    public void execute(String[] args) {
        try {
            id = Integer.parseInt(args[1]);
            System.out.println("Какой элемент вы хотите обновить? (имя, координаты, цена, тип билета");
            System.out.print("дата рождения, рост, вес, локация): ");
            while (true) {
                String input;
                if (commandProcessor.getScriptFlag()) {
                    input = commandProcessor.getNextCommand().trim();
                    System.out.println(input);
                } else {
                    Scanner scanner = new Scanner(System.in);
                    input = scanner.nextLine().trim();
                }
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
