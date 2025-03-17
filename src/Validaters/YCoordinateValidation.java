package Validaters;

import Commands.CommandProcessor;
import Console.Client;
import Tools.Validation;

import java.util.Scanner;

public class YCoordinateValidation implements Validation {
    private double y;
    private String message;
    private CommandProcessor commandProcessor;

    public YCoordinateValidation(String message, CommandProcessor commandProcessor) {
        this.message = message;
        this.commandProcessor = commandProcessor;
        validation();
    }

    public double validation() {
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
                this.y = Double.parseDouble(input);
                return this.y;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        }
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public String getErrorMessage() {
        return "Ошибка в Y";
    }
}