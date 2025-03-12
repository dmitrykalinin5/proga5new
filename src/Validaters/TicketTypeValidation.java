package Validaters;

import Tools.Validation;
import Collections.TicketType;
import Console.Client;

public class TicketTypeValidation implements Validation {
    private TicketType ticketType;
    private final Client client;
    private final String message;

    public TicketTypeValidation(Client client, String message) {
        this.client = client;
        this.message = message;
        validation();
    }

    public TicketType validation() {
        while (true) {
            try {
                System.out.print(message);
                this.ticketType = TicketType.valueOf(client.userInput().toUpperCase());
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