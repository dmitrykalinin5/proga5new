package Validaters;

import Console.Client;
import Tools.Validation;

public class YCoordinateValidation implements Validation {
    private double y;
    private Client client;
    private String message;

    public YCoordinateValidation(Client client, String message) {
        this.client = client;
        this.message = message;
        validation();
    }

    public double validation() {
        while (true) {
            try {
                System.out.print(message);
                this.y = Double.parseDouble(client.userInput());
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