package Validaters;

import Commands.CommandProcessor;
import Tools.Validation;
import Console.Client;

import java.util.Scanner;

public class PriceValidation implements Validation {
    private Long price;
    private final String message;
    private CommandProcessor commandProcessor;

    public PriceValidation(String message, CommandProcessor commandProcessor) {
        this.message = message;
        this.commandProcessor = commandProcessor;
        validation();
    }

    public Long validation() {
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
                this.price = Long.parseLong(input);
                if (!validate()) {
                    System.out.println("Цена должна быть больше 0");
                    continue;
                }
                return this.price;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        }
    }

    public Long getPrice() { return price; }

    @Override
    public boolean validate() {return price > 0;}

    @Override
    public String getErrorMessage() {return "Ошибка в цене";}
}