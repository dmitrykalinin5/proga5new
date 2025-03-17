package Validaters;

import Commands.CommandProcessor;
import Tools.Validation;
import Collections.TicketType;
import Console.Client;

import java.util.Scanner;

public class TicketTypeValidation implements Validation {
    private TicketType ticketType;
    private final String message;
    private CommandProcessor commandProcessor;

    public TicketTypeValidation(String message, CommandProcessor commandProcessor) {
        this.message = message;
        this.commandProcessor = commandProcessor;
        validation();
    }

    public TicketType validation() {
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
                this.ticketType = TicketType.valueOf(input.toUpperCase());
                return ticketType;
            } catch (IllegalArgumentException e) {
                System.out.println("Неправильный формат ввода");
            }
        }
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public String getErrorMessage() {
        return " ";
    }
}