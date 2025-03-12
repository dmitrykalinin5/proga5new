package Validaters;

import Tools.Validation;
import Console.Client;

public class XCoordinateValidation implements Validation {
    private int x;
    private Client client;
    private String message;

    public XCoordinateValidation(Client client, String message) {
        this.client = client;
        this.message = message;
        validation();
    }

    public int validation() {
        while (true) {
            try {
                System.out.print(message);
                this.x = Integer.parseInt(client.userInput());
                return this.x;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
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
