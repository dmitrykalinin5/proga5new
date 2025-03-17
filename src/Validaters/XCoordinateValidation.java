package Validaters;

import Commands.CommandProcessor;
import Tools.Validation;
import Console.Client;

import java.util.Scanner;

public class XCoordinateValidation implements Validation {
    private int x;
    private String message;
    private CommandProcessor commandProcessor;

    public XCoordinateValidation(String message, CommandProcessor commandProcessor) {
        this.message = message;
        this.commandProcessor = commandProcessor;
        validation();
    }

    public int validation() {
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
                this.x = Integer.parseInt(input);
                return this.x;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод" + e.toString());
            }
        }
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public String getErrorMessage() {
        return "Ошибка в x";
    }
}
