package Validaters;

import Commands.CommandProcessor;
import Console.Client;
import Tools.Validation;
import java.util.Scanner;

public class NameValidation implements Validation {
    private String name;
    private final String message;
    private CommandProcessor commandProcessor;

    public NameValidation(String message, CommandProcessor commandProcessor) {
        this.message = message;
        this.commandProcessor = commandProcessor;
        validation();
    }

    public String validation() {
        while (true) {
            try {
                System.out.print(message);
                String input;
                if (commandProcessor.getScriptFlag()) {
                    input = commandProcessor.getNextCommand().trim();
                    System.out.println(input);
                } else {
                    Scanner scanner = new Scanner(System.in);
                    input = scanner.nextLine().trim();
                }
                this.name = input;
                if (!validate()) {
                    System.out.println("Неверный формат ввода.");
                    continue;
                }
                return this.name;
            } catch (Exception e) {
                System.out.println("Некорректный ввод: " + e.getMessage());
            }
        }
    }

    public String getName() { return name; }

    @Override
    public boolean validate() {
        return name != null && !name.isEmpty();
    }

    @Override
    public String getErrorMessage() {
        return "Ошибка в ID";
    }
}